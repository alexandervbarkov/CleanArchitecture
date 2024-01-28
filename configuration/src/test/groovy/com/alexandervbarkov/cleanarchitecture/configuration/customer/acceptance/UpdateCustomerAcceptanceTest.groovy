package com.alexandervbarkov.cleanarchitecture.configuration.customer.acceptance

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer
import com.alexandervbarkov.cleanarchitecture.commoninfrastructure.api.ErrorResponse
import com.alexandervbarkov.cleanarchitecture.customercore.usecase.update.UpdateCustomerRequestSchema
import org.springframework.test.annotation.DirtiesContext

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch

class UpdateCustomerAcceptanceTest extends CustomerAcceptanceTest {

    @DirtiesContext
    def 'Update Customer'() {
        given:
        def createdCustomer = saveCustomer(buildCustomer())
        def request = UpdateCustomerRequestSchema.builder()
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

    def 'Update Customer invalid id'() {
        given:
        def request = UpdateCustomerRequestSchema.builder()
                .firstName(' ')
                .lastName(null)
                .isActive(null)
                .build()
        def expectedError = new ErrorResponse(["id must be greater than or equal to 1, but was '0'"])

        when:
        def response = mvc.perform(
                patch("/customers/0")
                        .content(toJson(request))
                        .contentType('application/merge-patch+json')
        )
                .andReturn()
                .response

        then:
        response.status == 400
        assertResponseBodyEqualsExpected(response, expectedError)
    }

    def 'Update Customer invalid jsonMergePatch'() {
        given:
        def request = UpdateCustomerRequestSchema.builder()
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
                patch("/customers/1")
                        .content(toJson(request))
                        .contentType('application/merge-patch+json')
        )
                .andReturn()
                .response

        then:
        response.status == 400
        assertResponseBodyEqualsExpected(response, expectedError)
    }
}
