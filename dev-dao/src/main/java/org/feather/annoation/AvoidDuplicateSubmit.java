package org.feather.annoation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author feather
 * @projectName dev-common
 * @description: TODO
 * @since 28-Jul-22 5:49 PM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AvoidDuplicateSubmit {
    /**
     * @return long
     * @Description 指定时间内不可重复提交，单位秒
     **/
    long timeout() default 2;
}
