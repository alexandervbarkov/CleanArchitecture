package com.alexandervbarkov.cleanarchitecture.commoncore.validation;

import com.alexandervbarkov.cleanarchitecture.commoncore.exception.BadRequestException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import javax.inject.Named;
import java.util.List;
import java.util.Set;

@Named
public class ValidatorHibernate implements com.alexandervbarkov.cleanarchitecture.commoncore.validation.Validator {
    private final Validator validator;

    public ValidatorHibernate() {
        try (var factory = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory()
        ) {
            validator = factory.getValidator();
        }
    }

    public void validate(Object object) {
        var violations = validator.validate(object);
        if (!violations.isEmpty()) {
            handleViolations(violations);
        }
    }

    private void handleViolations(Set<ConstraintViolation<Object>> violations) {
        var violationMessages = buildViolationMessages(violations);
        throw new BadRequestException(violationMessages);
    }

    private List<String> buildViolationMessages(Set<ConstraintViolation<Object>> violations) {
        return violations.stream()
                .map(this::buildViolationMessage)
                .toList();
    }

    private String buildViolationMessage(ConstraintViolation<Object> violation) {
        return violation.getPropertyPath().toString() + " " + violation.getMessage() + ", but was '" + violation.getInvalidValue() + "'";
    }
}
