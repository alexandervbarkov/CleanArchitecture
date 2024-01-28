package com.alexandervbarkov.cleanarchitecture.commoncore.validation.jsonmergepatch;

import com.alexandervbarkov.cleanarchitecture.commoncore.exception.BadRequestException;
import com.alexandervbarkov.cleanarchitecture.commoncore.json.Jsons;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;
import java.util.Optional;

@Named
@RequiredArgsConstructor
public class JsonMergePatchValidator {
    private final Jsons jsons;

    public void validate(String jsonMergePatch, List<? extends Constraint> constraints) {
        var jsonNode = jsons.toJsonNode(jsonMergePatch);
        List<String> errorMessages = getErrorMessages(constraints, jsonNode);
        if (!errorMessages.isEmpty()) {
            throw new BadRequestException(errorMessages);
        }
    }

    private static List<String> getErrorMessages(List<? extends Constraint> constraints, JsonNode jsonNode) {
        return constraints.stream()
                .map(constraint -> constraint.validate(jsonNode))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
