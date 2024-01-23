package com.alexandervbarkov.cleanarchitecture.testutil


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

    protected void assertResponseBodyEqualsExpected(MockHttpServletResponse response, Object expected) {
        JsonUtils.assertResponseBodyEqualExpected(response, expected)
    }
}
