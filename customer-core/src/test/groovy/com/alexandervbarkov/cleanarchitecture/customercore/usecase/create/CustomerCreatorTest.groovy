package com.alexandervbarkov.cleanarchitecture.customercore.usecase.create

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create.CreateCustomerRequest
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SaveCustomerGateway
import spock.lang.Specification

import static com.alexandervbarkov.cleanarchitecture.customercore.testutils.CustomerUtils.buildCustomer

class CustomerCreatorTest extends Specification {
    SaveCustomerGateway gateway = Mock()
    CreateCustomerRequestMapper mapper = new CreateCustomerRequestMapperImpl()
    def customerCreator = new CustomerCreator(gateway, mapper)

    def "Create"() {
        given:
        def request = CreateCustomerRequest.builder()
                .firstName('firstName')
                .lastName('lastName')
                .isActive(true)
                .build()
        def customerWithoutId = Customer.builder()
                .firstName('firstName')
                .lastName('lastName')
                .isActive(true)
                .build()

        when:
        def actual = customerCreator.create(request)

        then:
        1 * gateway.save(customerWithoutId) >> buildCustomer()
        actual == buildCustomer()
    }
}
