package com.app.advices.validation.anotation;

import com.app.advices.validation.validator.ValidNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidNameValidator.class)
@Retention(RetentionPolicy.RUNTIME) // --> La anotación estará disponible en tiempo de ejecución
@Target({ElementType.FIELD, ElementType.METHOD}) // --> La anotación solo puede aplicarse a campos o métodos
public @interface ValidName {
    String message() default "{custom.valid.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
