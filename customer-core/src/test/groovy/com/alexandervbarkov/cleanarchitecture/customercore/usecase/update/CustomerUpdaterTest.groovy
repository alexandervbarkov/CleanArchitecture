package com.alexandervbarkov.cleanarchitecture.customercore.usecase.update

import com.alexandervbarkov.cleanarchitecture.commoncore.exception.ResourceNotFoundException
import com.alexandervbarkov.cleanarchitecture.commoncore.mergepatch.MergePatches
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.GetCustomerByIdGateway
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SaveCustomerGateway
import spock.lang.Specification

import static com.alexandervbarkov.cleanarchitecture.customercore.testutils.CustomerUtils.buildCustomer

class CustomerUpdaterTest extends Specification {
    GetCustomerByIdGateway getCustomerByIdGateway = Mock()
    SaveCustomerGateway saveCustomerGateway = Mock()
    MergePatches mergePatches = Mock()
    def customerUpdater = new CustomerUpdater(
            getCustomerByIdGateway,
            saveCustomerGateway,
            mergePatches
    )

    def "Update"() {
        when:
        def actual = customerUpdater.update(1, 'customerJsonPatch')

        then:
        1 * getCustomerByIdGateway.get(1) >> Optional.of(buildCustomer())
        1 * mergePatches.mergePatch(buildCustomer(), 'customerJsonPatch') >> buildCustomer()
        1 * saveCustomerGateway.save(buildCustomer()) >> buildCustomer()
        actual == buildCustomer()
    }

    def "Update when customer is not found"() {
        when:
        customerUpdater.update(1, 'customerJsonPatch')

        then:
        1 * getCustomerByIdGateway.get(1) >> Optional.empty()
        def ex = thrown(ResourceNotFoundException)
        ex.getMessage() == 'Cannot find Customer with ID: 1'
    }
}
