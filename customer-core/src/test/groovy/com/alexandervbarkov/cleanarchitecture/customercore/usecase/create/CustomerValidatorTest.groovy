package com.alexandervbarkov.cleanarchitecture.customercore.usecase.create

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create.CreateCustomerRequest
import com.alexandervbarkov.cleanarchitecture.commoncore.exception.BadRequestException
import com.alexandervbarkov.cleanarchitecture.commoncore.validation.ModelValidator
import spock.lang.Specification

class CustomerValidatorTest extends Specification {
    def validator = new CustomerValidator(new ModelValidator())

    def "Validate"() {
        given:
        def request = CreateCustomerRequest.builder()
                .firstName('valid')
                .lastName('valid')
                .isActive(true)
                .build()

        when:
        validator.validate(request)

        then:
        notThrown(BadRequestException)
    }

    def "Validate throws exception"() {
        given:
        def request = CreateCustomerRequest.builder()
                .firstName(' ')
                .build()

        def expectedErrorMessages = [
                "firstName must not be blank, but was ' '",
                "lastName must not be blank, but was 'null'",
                "isActive must not be null, but was 'null'"
        ]

        when:
        validator.validate(request)

        then:
        def ex = thrown(BadRequestException)
        ex.messages.size() == expectedErrorMessages.size()
        ex.messages.containsAll(expectedErrorMessages)
    }
}
