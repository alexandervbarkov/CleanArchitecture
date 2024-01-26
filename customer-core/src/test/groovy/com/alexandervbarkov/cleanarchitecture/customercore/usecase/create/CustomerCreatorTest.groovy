package com.alexandervbarkov.cleanarchitecture.customercore.usecase.create

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.CustomerDto
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create.CreateCustomerRequest
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.CreateCustomerGateway
import spock.lang.Specification

import static com.alexandervbarkov.cleanarchitecture.customercore.testutils.CustomerUtils.buildCustomer

class CustomerCreatorTest extends Specification {
    CreateCustomerGateway gateway = Mock()
    CreateCustomerRequestMapper mapper = new CreateCustomerRequestMapperImpl()
    def customerCreator = new CustomerCreator(gateway, mapper)

    def "Create"() {
        given:
        def request = new CreateCustomerRequestTest(firstName: 'firstName', lastName: 'lastName')
        def customerWithoutId = CustomerDto.builder()
                .firstName('firstName')
                .lastName('lastName')
                .build()

        when:
        def actual = customerCreator.create(request)

        then:
        1 * gateway.create(customerWithoutId) >> buildCustomer()
        actual == buildCustomer()
    }

    static class CreateCustomerRequestTest implements CreateCustomerRequest {
        String firstName
        String lastName
    }
}
