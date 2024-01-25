package com.alexandervbarkov.cleanarchitecture.commoninfrastructure.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Jsons {
    private final ObjectMapper objectMapper;

    public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T toObject(String json, Class<T> type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T mergePatch(T objectToPatch, String jsonMergePatch) {
        String jsonToPatch = toJson(objectToPatch);
        String jsonPatched = mergePatch(jsonToPatch, jsonMergePatch);
        //noinspection unchecked
        return (T) toObject(jsonPatched, objectToPatch.getClass());
    }

    private String mergePatch(String jsonToPatch, String jsonMergePatch) {
        var jsonNodeToPatch = toJsonNode(jsonToPatch);
        var jsonNodeMergePatch = toJsonNode(jsonMergePatch);
        var jsonNodePatched = mergePatch(jsonNodeToPatch, jsonNodeMergePatch);
        return jsonNodePatched.toString();
    }

    private JsonNode mergePatch(JsonNode jsonNodeToPatch, JsonNode jsonNodeMergePatch) {
        try {
            var jsonMergePatch = JsonMergePatch.fromJson(jsonNodeMergePatch);
            return jsonMergePatch.apply(jsonNodeToPatch);
        } catch (JsonPatchException e) {
            throw new RuntimeException(e);
        }
    }

    private JsonNode toJsonNode(String json) {
        try {
            return objectMapper.readTree(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
