package com.app.advices.validation.validator;

import com.app.advices.validation.anotation.ValidName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNameValidator implements ConstraintValidator<ValidName, String> {

    // Ignorar
//    @Override
//    public void initialize(ValidName constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
//    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if (value.isEmpty()) {
            return false;
        }

        if (value.isBlank()) {
            return false;
        }

        if (value.length() > 20) {
            return false;
        }

        if (value.length() < 3) {
            return false;
        }

        if (!Character.isUpperCase(value.charAt(0))) {
            return false;
        }

        return true;
    }
}
