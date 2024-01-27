package com.alexandervbarkov.cleanarchitecture.configuration.customer.acceptance


import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create.CreateCustomerRequest
import com.alexandervbarkov.cleanarchitecture.commoninfrastructure.api.ErrorResponse
import org.springframework.test.annotation.DirtiesContext

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

class CreateCustomerAcceptanceTest extends CustomerAcceptanceTest {

    @DirtiesContext
    def 'Create Customer'() {
        given:
        def request = CreateCustomerRequest.builder()
                .firstName('firstName')
                .lastName('lastName')
                .isActive(true)
                .build()
        def expectedCustomer = Customer.builder()
                .id(1)
                .firstName('firstName')
                .lastName('lastName')
                .isActive(true)
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
        def request = CreateCustomerRequest.builder()
                .firstName(' ')
                .lastName(null)
                .isActive(null)
                .build()
        def expectedError = new ErrorResponse([
                "firstName must not be blank, but was ' '",
                "lastName must not be blank, but was 'null'",
                "isActive must not be null, but was 'null'"
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
