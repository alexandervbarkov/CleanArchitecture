package com.alexandervbarkov.cleanarchitecture.commoncore.validation.jsonmergepatch;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NotNull extends Constraint {
    private static final String violationMessage = "must not be null";
    private final String fieldName;

    @Override
    protected boolean isInvalid(JsonNode field) {
        return field.isNull();
    }

    @Override
    protected String getViolationMessage() {
        return violationMessage;
    }
}