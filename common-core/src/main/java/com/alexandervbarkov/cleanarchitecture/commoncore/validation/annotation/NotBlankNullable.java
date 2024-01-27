package com.alexandervbarkov.cleanarchitecture.commoncore.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = NotBlankNullable.NotBlankNullableValidator.class)
public @interface NotBlankNullable {
    String message() default "cannot be blank";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class NotBlankNullableValidator implements ConstraintValidator<NotBlankNullable, String> {
        public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
            return value == null || !value.trim().isEmpty();
        }
    }
}