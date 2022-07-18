package org.feather.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.feather.annoation.Log;
import org.feather.domain.SysLog;
import org.feather.domain.User;
import org.feather.service.ISysLogService;
import org.feather.support.UserSupport;
import org.feather.utils.HttpContextUtils;
import org.feather.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author feather
 * @projectName dev-common
 * @description: TODO
 * @since 18-Jul-22 4:07 PM
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Aspect
@Component
public class LogAspect {

    private  final UserSupport userSupport;

    private  final ISysLogService sysLogService;

    @Pointcut("@annotation(org.feather.annoation.Log)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint point) {
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(point, time);
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        sysLog.setTime((int) time);
        Log logAnnotation = method.getAnnotation(Log.class);
        if (logAnnotation != null) {
            // 注解上的描述
            sysLog.setOperation(logAnnotation.description());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            String params = "";
            for (int i = 0; i < args.length; i++) {
                params += "  " + paramNames[i] + ": " + args[i];
            }
            sysLog.setParams(params);
        }
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //设置请求地址
        sysLog.setUri(request.getRequestURI());
        //请求的方法类型(post/get)
        sysLog.setMethodType(request.getMethod());
        // 设置IP地址
        sysLog.setIp(IpUtil.getIpAddr(request));
        sysLog.setContentType(request.getContentType());
//        User currentUserInfo = userSupport.getCurrentUserInfo();
//        if (currentUserInfo!=null){
//            sysLog.setUsername(currentUserInfo.getUsername());
//        }
        sysLog.setUser("duxuesong");
        sysLog.setCreateTime(new Date());
        // 保存系统日志
        sysLogService.save(sysLog);
    }
}
