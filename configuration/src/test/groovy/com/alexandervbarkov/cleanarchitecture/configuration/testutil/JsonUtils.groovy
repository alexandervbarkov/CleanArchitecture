package com.alexandervbarkov.cleanarchitecture.configuration.testutil

import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.PageDto
import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.ObjectMapper
import org.skyscreamer.jsonassert.JSONAssert
import org.springframework.mock.web.MockHttpServletResponse

class JsonUtils {
    static final ObjectMapper objectMapper = new ObjectMapper()

    static <T> PageDto<T> toPage(String json, Class<T> contentType) {
        JavaType type = objectMapper.getTypeFactory().constructParametricType(PageDto, contentType)
        objectMapper.readValue(json, type)
    }

    static String toJson(Object o) {
        objectMapper.writeValueAsString(o)
    }

    static void assertEqual(String first, String second) {
        JSONAssert.assertEquals(first, second, false)
    }

    static void assertResponseBodyEqualExpected(MockHttpServletResponse actual, Object expected) {
        assertEqual(toJson(expected), actual.contentAsString)
    }
}
