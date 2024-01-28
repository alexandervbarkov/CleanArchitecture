package com.alexandervbarkov.cleanarchitecture.customercore.usecase.update

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.update.UpdateCustomerRequest
import spock.lang.Specification

import static com.alexandervbarkov.cleanarchitecture.customercore.testutils.CustomerUtils.buildCustomer

class UpdateCustomerFacadeTest extends Specification {
    UpdateCustomerRequestValidator validator = Mock()
    CustomerUpdater updater = Mock()
    def facade = new UpdateCustomerFacade(
            new UpdateCustomerChain.UpdateCustomerRequestValidatorChain(validator),
            new UpdateCustomerChain.CustomerUpdaterChain(updater)
    )

    def "Update Customer Facade"() {
        given:
        UpdateCustomerRequest request = UpdateCustomerRequest.builder().build()

        when:
        def actual = facade.update(request)

        then:
        1 * validator.validate(request)
        1 * updater.update(request) >> buildCustomer()
        actual == buildCustomer()
    }
}
