package com.alexandervbarkov.cleanarchitecture.customercore.usecase.create

import com.alexandervbarkov.cleanarchitecture.commoncore.exception.BadRequestException
import com.alexandervbarkov.cleanarchitecture.commoncore.validation.ModelValidator
import spock.lang.Specification

class CustomerValidatorTest extends Specification {
    def validator = new CustomerValidator(new ModelValidator(), new CreateCustomerRequestMapperImpl())

    def "Validate"() {
        given:
        def request = CreateCustomerRequestDto.builder()
                .firstName('valid')
                .lastName('valid')
                .build()

        when:
        validator.validate(request)

        then:
        notThrown(BadRequestException)
    }

    def "Validate throws exception"() {
        given:
        def request = CreateCustomerRequestDto.builder()
                .firstName(' ')
                .lastName(null)
                .build()

        when:
        validator.validate(request)

        then:
        def ex = thrown(BadRequestException)
        ex.messages.containsAll([
                "firstName must not be blank, but was ' '",
                "lastName must not be blank, but was 'null'"
        ])
    }
}
