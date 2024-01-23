package com.alexandervbarkov.cleanarchitecture.customer.acceptance

import com.alexandervbarkov.cleanarchitecture.customer.core.entity.CustomerDto
import com.alexandervbarkov.cleanarchitecture.customer.infrastructure.api.create.CreateCustomerRestRequest

import static com.alexandervbarkov.cleanarchitecture.testutil.JsonUtils.toJson
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

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

        when:
        def response = mvc.perform(
                post("/customers")
                        .content(toJson(request))
                        .contentType(APPLICATION_JSON_VALUE)
        )
                .andReturn()
                .response

        then:
        response.status == 200
        assertResponseBodyEqualsExpected(response, expectedCustomer)
        assertCustomerExistsInDb(expectedCustomer)
    }
}
