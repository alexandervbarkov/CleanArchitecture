package com.alexandervbarkov.cleanarchitecture.customercore.usecase.update

import com.alexandervbarkov.cleanarchitecture.commoncore.exception.ResourceNotFoundException
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.UpdateCustomerGateway
import spock.lang.Specification

import static com.alexandervbarkov.cleanarchitecture.customercore.testutils.CustomerUtils.buildCustomer

class CustomerUpdaterTest extends Specification {
    UpdateCustomerGateway gateway = Mock()
    def customerUpdater = new CustomerUpdater(gateway)

    def "Update"() {
        when:
        def actual = customerUpdater.update(1, 'customerJsonPatch')

        then:
        1 * gateway.update(1, 'customerJsonPatch') >> Optional.of(buildCustomer())
        actual == buildCustomer()
    }

    def "Update when customer is not found"() {
        when:
        customerUpdater.update(1, 'customerJsonPatch')

        then:
        1 * gateway.update(1, 'customerJsonPatch') >> Optional.empty()
        def ex = thrown(ResourceNotFoundException)
        ex.getMessage() == 'Cannot find Customer with ID: 1'
    }
}
