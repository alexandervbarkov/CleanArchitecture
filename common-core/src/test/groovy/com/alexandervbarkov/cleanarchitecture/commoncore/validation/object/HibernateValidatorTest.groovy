package com.alexandervbarkov.cleanarchitecture.commoncore.validation.object

import com.alexandervbarkov.cleanarchitecture.commoncore.exception.BadRequestException
import groovy.transform.EqualsAndHashCode
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import spock.lang.Specification

class HibernateValidatorTest extends Specification {
    def validator = new HibernateValidator()

    def "Validate valid object"() {
        given:
        def object = new Wrapper(integer: 1, string: 's', bool: false)

        when:
        validator.validate(object)

        then:
        notThrown(BadRequestException)
    }

    def "Validate invalid object"() {
        given:
        def object = new Wrapper(integer: 0, string: ' ')
        def expectedViolations = [
                "string must not be blank, but was ' '",
                "integer must be greater than or equal to 1, but was '0'",
                "bool must not be null, but was 'null'"
        ]

        when:
        validator.validate(object)

        then:
        def ex = thrown(BadRequestException)
        ex.messages.size() == expectedViolations.size()
        ex.messages.containsAll(expectedViolations)
    }

    @EqualsAndHashCode
    static class Wrapper {
        @Min(1)
        int integer
        @NotBlank
        String string
        @NotNull
        Boolean bool
    }
}
