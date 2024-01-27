package com.alexandervbarkov.cleanarchitecture.commoncore.mergepatch;

import com.alexandervbarkov.cleanarchitecture.commoncore.json.Jsons;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class MergePatchesFge implements MergePatches {
    private final Jsons jsons;

    public <T> T mergePatch(T objectToPatch, String jsonMergePatch) {
        String jsonToPatch = jsons.toJson(objectToPatch);
        String jsonPatched = mergePatch(jsonToPatch, jsonMergePatch);
        //noinspection unchecked
        return (T) jsons.toObject(jsonPatched, objectToPatch.getClass());
    }

    private String mergePatch(String jsonToPatch, String jsonMergePatch) {
        var jsonNodeToPatch = jsons.toJsonNode(jsonToPatch);
        var jsonNodeMergePatch = jsons.toJsonNode(jsonMergePatch);
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
}
