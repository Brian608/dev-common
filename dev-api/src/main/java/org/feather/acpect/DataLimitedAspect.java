package org.feather.acpect;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.feather.constants.QueryConstant;
import org.feather.domain.User;
import org.feather.query.QueryModel;
import org.feather.support.UserSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author feather
 * @projectName dev-common
 * @description: TODO
 * @since 27-Jun-22 2:14 PM
 */
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
@Aspect
public class DataLimitedAspect {
    private final UserSupport userSupport;

    @Pointcut("@annotation(org.feather.annoation.DataLimited)")
    public void check() {

    }

    @Before("check()")
    public void doBefore(JoinPoint joinPoint) {
        User user = userSupport.getCurrentUserInfo();
        Set<String> areaCodeList = Arrays.stream(user.getAreaCode().split(",")).collect(Collectors.toSet());
        Object[] args = joinPoint.getArgs();
        for (Object o : args) {
            if (o instanceof QueryModel) {
                try {
                    Field declaredField = o.getClass().getDeclaredField(QueryConstant.dataLimitArea);
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(o);
                    if (obj==null){
                        declaredField.set(o,areaCodeList);
                    }
                }catch (Exception e){

                }

                break;
            }
        }


    }
}
