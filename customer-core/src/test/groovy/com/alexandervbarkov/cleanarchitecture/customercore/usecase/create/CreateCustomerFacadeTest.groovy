package com.alexandervbarkov.cleanarchitecture.customercore.usecase.create

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create.CreateCustomerRequest
import com.alexandervbarkov.cleanarchitecture.commoncore.validation.Validator
import spock.lang.Specification

import static com.alexandervbarkov.cleanarchitecture.customercore.testutils.CustomerUtils.buildCustomer

class CreateCustomerFacadeTest extends Specification {
    Validator validator = Mock()
    CustomerCreator creator = Mock()
    def facade = new CreateCustomerFacade(
            new CreateCustomerChain.CustomerValidatorChain(validator),
            new CreateCustomerChain.CustomerCreatorChain(creator)
    )

    def "Create Customer Chain"() {
        given:
        CreateCustomerRequest request = CreateCustomerRequest.builder().build()

        when:
        def actual = facade.create(request)

        then:
        1 * validator.validate(request)
        1 * creator.create(request) >> buildCustomer()
        actual == buildCustomer()
    }
}
