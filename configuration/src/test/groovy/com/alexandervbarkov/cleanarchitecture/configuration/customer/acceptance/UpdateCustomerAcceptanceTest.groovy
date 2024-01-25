package com.alexandervbarkov.cleanarchitecture.configuration.customer.acceptance

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.CustomerDto
import com.alexandervbarkov.cleanarchitecture.customerinfrastructure.api.update.UpdateCustomerRestRequest

import static com.alexandervbarkov.cleanarchitecture.configuration.customer.testutil.CustomerUtils.buildCustomer
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch

class UpdateCustomerAcceptanceTest extends CustomerAcceptanceTest {

    def 'Update Customer'() {
        given:
        def createdCustomer = createCustomer(buildCustomer())
        def request = new UpdateCustomerRestRequest(firstName: 'newFirstName', lastName: 'newLastName')
        def expectedCustomer = CustomerDto.builder()
                .id(createdCustomer.id)
                .firstName('newFirstName')
                .lastName('newLastName')
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
