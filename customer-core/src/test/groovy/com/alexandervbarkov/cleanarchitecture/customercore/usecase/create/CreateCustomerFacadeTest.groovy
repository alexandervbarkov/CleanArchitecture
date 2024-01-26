package com.alexandervbarkov.cleanarchitecture.customercore.usecase.create

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create.CreateCustomerRequest
import spock.lang.Specification

import static com.alexandervbarkov.cleanarchitecture.customercore.testutils.CustomerUtils.buildCustomer

class CreateCustomerFacadeTest extends Specification {
    CustomerValidator validator = Mock()
    CustomerCreator creator = Mock()
    def facade = new CreateCustomerFacade(
            new CreateCustomerChain.CustomerValidatorChain(validator),
            new CreateCustomerChain.CustomerCreatorChain(creator)
    )

    def "Create Customer Chain"() {
        given:
        CreateCustomerRequest request = Mock()

        when:
        def actual = facade.create(request)

        then:
        1 * validator.validate(request)
        1 * creator.create(request) >> buildCustomer()
        actual == buildCustomer()
    }
}