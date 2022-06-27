package org.feather.annoation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author feather
 * @projectName dev-common
 * @description: TODO
 * @since 27-Jun-22 2:15 PM
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Component
public @interface DataLimited {
}
