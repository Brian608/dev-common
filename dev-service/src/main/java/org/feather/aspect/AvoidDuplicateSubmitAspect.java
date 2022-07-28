package org.feather.aspect;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.feather.annoation.AvoidDuplicateSubmit;
import org.feather.constants.StaticValue;
import org.feather.exception.ConditionException;
import org.feather.support.UserSupport;
import org.feather.utils.IpUtil;
import org.feather.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * @author feather
 * @projectName dev-common
 * @description: TODO
 * @since 28-Jul-22 5:50 PM
 */
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
@Aspect
@Slf4j
public class AvoidDuplicateSubmitAspect {

    private final RedisUtils redisUtils;

    private final UserSupport userSupport;
    /**
     * 定义切入点
     */
    @Pointcut("@annotation(org.feather.annoation.AvoidDuplicateSubmit))")
    public void noRepeat() {}


    @Around("noRepeat()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        // 获取request对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Assert.notNull(request, "request not null");
        // 获取用户信息
        Long userId = userSupport.getCurrentUserInfo().getId();
        // 获取ip
        String ip = IpUtil.getIpAddr(request);

        // 获取方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        // 获取类名、方法名、参数
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();
        Map<String, String[]> parameMap = request.getParameterMap();
        StringBuilder parameStr = new StringBuilder("");
        // js 会传这个参数variableParameter（时间戳）
        for (Map.Entry<String, String[]> entry : parameMap.entrySet()) {
            if (!"variableParameter".equals(entry.getKey())) {
                parameStr.append(Arrays.toString(entry.getValue()));
            }
        }
        // 拼接key
        String lockKey_last = String.format("%s#%s#%s#%s", userId, className, methodName, parameStr);
        int hashCode = Math.abs(lockKey_last.hashCode());
        // 拼接redisKey,如：127.0.0.1_1898984393
        String lockKey = StaticValue.COMMON_DUPLICATE_SUBMIT + ":" + String.format("%s_%d", ip, hashCode);
        log.info("lockKey = " + lockKey + "   lockKey_last =" + lockKey_last);
        // 获取注解的过期时间
        AvoidDuplicateSubmit avoidDuplicateSubmit = method.getAnnotation(AvoidDuplicateSubmit.class);
        long timeout = avoidDuplicateSubmit.timeout();
        if (timeout <= 0) {
            timeout = 2;
        }
        // 从redis获取数据
        Object redisValue = redisUtils.get(lockKey);
        // 判断是否存在
        if (!Objects.isNull(redisValue)) {
            throw new ConditionException("请勿重复提交");
        }
        // 第一次提交，插入redis
        boolean resultBoolean = redisUtils.setIfAbsent(lockKey, String.valueOf(UUID.randomUUID()), timeout);
        // 如果失败，说明存在
        log.info("resultBoolean =" + resultBoolean);
        if (!resultBoolean) {
            throw new ConditionException("请勿重复提交");
        }
        // 继续执行方法
        return joinPoint.proceed();
    }
}
