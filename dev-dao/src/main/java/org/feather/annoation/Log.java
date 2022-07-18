package org.feather.annoation;

import java.lang.annotation.*;

/**
 * @author feather
 * @projectName dev-common
 * @description: TODO
 * @since 18-Jul-22 4:04 PM
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public  @interface Log {

    String description() default "";
}
