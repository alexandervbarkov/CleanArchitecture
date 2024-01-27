package com.alexandervbarkov.cleanarchitecture.commoncore.json;

import com.fasterxml.jackson.databind.JsonNode;

public interface Jsons {

    String toJson(Object object);

    <T> T toObject(String json, Class<T> type);

    JsonNode toJsonNode(String json);
}
