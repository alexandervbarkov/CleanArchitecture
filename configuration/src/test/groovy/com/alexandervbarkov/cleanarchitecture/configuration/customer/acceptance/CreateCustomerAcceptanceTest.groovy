package com.alexandervbarkov.cleanarchitecture.configuration.customer.acceptance

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.CustomerDto
import com.alexandervbarkov.cleanarchitecture.commoninfrastructure.api.ErrorResponse
import com.alexandervbarkov.cleanarchitecture.customerinfrastructure.api.create.CreateCustomerRestRequest

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
        response.status == 201
        assertResponseBodyEqualsExpected(response, expectedCustomer)
        assertCustomerExistsInDb(expectedCustomer)
    }

    def 'Create Customer invalid request'() {
        given:
        def request = CreateCustomerRestRequest.builder()
                .firstName(' ')
                .lastName(null)
                .build()
        def expectedError = new ErrorResponse([
                "firstName must not be blank, but was ' '",
                "lastName must not be blank, but was 'null'"
        ])

        when:
        def response = mvc.perform(
                post("/customers")
                        .content(toJson(request))
                        .contentType(APPLICATION_JSON_VALUE)
        )
                .andReturn()
                .response

        then:
        response.status == 400
        assertResponseBodyEqualsExpected(response, expectedError)
    }
}
