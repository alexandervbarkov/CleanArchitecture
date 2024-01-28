package com.alexandervbarkov.cleanarchitecture.commoncore.validation.jsonmergepatch;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Optional;

public abstract class Constraint {
    public Optional<String> validate(JsonNode jsonMergePatch) {
        return jsonMergePatch.has(getFieldName()) && isInvalid(jsonMergePatch.get(getFieldName()))
                ? Optional.of(buildViolationMessage(getFieldName(), jsonMergePatch.get(getFieldName())))
                : Optional.empty();
    }

    private String buildViolationMessage(String fieldName, JsonNode field) {
        return fieldName + " " + getViolationMessage() + ", but was '" + field.asText() + "'";
    }

    protected abstract boolean isInvalid(JsonNode field);

    protected abstract String getFieldName();

    protected abstract String getViolationMessage();

}
