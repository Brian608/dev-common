package org.feather.handler;

/**
 * @projectName: dev-common
 * @package: org.feather.handler
 * @className: EnumValueValidator
 * @author: feather(杜雪松)
 * @description:枚举校验注解处理类
 * @since: 2022/6/3 13:24
 * @version: 1.0
 */

import org.feather.annoation.EnumValue;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumValueValidator implements ConstraintValidator<EnumValue, Object> {

    private String[] strValues;
    private int[] intValues;

    @Override
    public void initialize(EnumValue constraintAnnotation) {
        strValues = constraintAnnotation.strValues();
        intValues = constraintAnnotation.intValues();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value instanceof String) {
            for (String s : strValues) {
                if (s.equals(value)) {
                    return true;
                }
            }
        } else if (value instanceof Integer) {
            for (int s : intValues) {
                if (s == (Integer) value) {
                    return true;
                }
            }
        }
        return false;
    }
}

