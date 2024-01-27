package com.alexandervbarkov.cleanarchitecture.configuration.customer.acceptance

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.update.UpdateCustomerRequest
import org.springframework.test.annotation.DirtiesContext

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch

class UpdateCustomerAcceptanceTest extends CustomerAcceptanceTest {

    @DirtiesContext
    def 'Update Customer'() {
        given:
        def createdCustomer = createCustomer(buildCustomer())
        def request = UpdateCustomerRequest.builder()
                .firstName('newFirstName')
                .lastName('newLastName')
                .isActive(false)
                .build()
        def expectedCustomer = Customer.builder()
                .id(createdCustomer.id)
                .firstName('newFirstName')
                .lastName('newLastName')
                .isActive(false)
                .build()

        when:
        def response = mvc.perform(
                patch("/customers/$createdCustomer.id")
                        .content(toJson(request))
                        .contentType('application/merge-patch+json')
        )
                .andReturn()
                .response

        then:
        response.status == 200
        assertResponseBodyEqualsExpected(response, expectedCustomer)
        assertCustomerExistsInDb(expectedCustomer)
    }
}
