package com.alexandervbarkov.cleanarchitecture.configuration

import com.alexandervbarkov.cleanarchitecture.commoncore.json.Jsons
import org.skyscreamer.jsonassert.JSONAssert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.mock.web.MockHttpServletResponse
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

@SpringBootTest
@AutoConfigureMockMvc
abstract class AcceptanceTest extends Specification {
    @Autowired
    protected MockMvc mvc

    @Autowired
    protected Jsons jsons

    protected String toJson(Object object) {
        jsons.toJson(object)
    }

    protected void assertResponseBodyEqualsExpected(MockHttpServletResponse response, Object expected) {
        assertEqual(toJson(expected), response.contentAsString)
    }

    private void assertEqual(String first, String second) {
        JSONAssert.assertEquals(first, second, false)
    }
}
