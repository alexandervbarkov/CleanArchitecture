package com.alexandervbarkov.cleanarchitecture.configuration.customer.acceptance

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.CustomerDto
import com.alexandervbarkov.cleanarchitecture.configuration.testutil.JsonUtils
import com.alexandervbarkov.cleanarchitecture.customerinfrastructure.api.create.CreateCustomerRestRequest

import static com.alexandervbarkov.cleanarchitecture.configuration.testutil.JsonUtils.toJson
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class CreateCustomerAcceptanceTest extends CustomerAcceptanceTest {

    def 'Create Customer'() {
        given:
        def request = CreateCustomerRestRequest.builder()
                .firstName('firstName')
                .lastName('lastName')
                .build()
        def expectedCustomer = CustomerDto.builder()
                .id(1)
                .firstName('firstName')
                .lastName('lastName')
                .build()

        def json = toJson(request)
        when:
        def response = mvc.perform(
                post("/customers")
                        .content(json)
                        .contentType(APPLICATION_JSON_VALUE)
        ).andDo(print())
                .andReturn()
                .response

        then:
        response.status == 200
        assertResponseBodyEqualsExpected(response, expectedCustomer)
        assertCustomerExistsInDb(expectedCustomer)
    }
}
