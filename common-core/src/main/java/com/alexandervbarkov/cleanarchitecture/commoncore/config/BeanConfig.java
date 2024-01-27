package com.alexandervbarkov.cleanarchitecture.commoncore.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Named;

public class BeanConfig {
    @Named
    public static ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
