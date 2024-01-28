package com.alexandervbarkov.cleanarchitecture.commoncore.validation.jsonmergepatch

import com.alexandervbarkov.cleanarchitecture.commoncore.config.BeanConfig
import com.alexandervbarkov.cleanarchitecture.commoncore.exception.BadRequestException
import com.alexandervbarkov.cleanarchitecture.commoncore.json.JsonsJackson
import spock.lang.Specification

class JsonMergePatchValidatorTest extends Specification {
    def validator = new JsonMergePatchValidator(new JsonsJackson(BeanConfig.objectMapper()))

    def "Validate when invalid"() {
        when:
        validator.validate(jsonMergePatch, constraints)

        then:
        def ex = thrown(BadRequestException)
        ex.messages.size() == errorMessages.size()
        ex.messages.containsAll(errorMessages)

        where:
        jsonMergePatch | constraints         | errorMessages
        '{"a": null}'  | [new NotNull('a')]  | ['a must not be null, but was \'null\'']
        '{"a": null}'  | [new NotBlank('a')] | ['a must not be blank, but was \'null\'']
        '{"a": " "}'   | [new NotBlank('a')] | ['a must not be blank, but was \' \'']
    }

    def "Validate when multiple invalid"() {
        given:
        def jsonMergePatch = '{"a": null}'
        def constraints = [new NotNull('a'), new NotBlank('a')]
        def errorMessages = ['a must not be null, but was \'null\'', 'a must not be blank, but was \'null\'']

        when:
        validator.validate(jsonMergePatch, constraints)

        then:
        def ex = thrown(BadRequestException)
        ex.messages.size() == errorMessages.size()
        ex.messages.containsAll(errorMessages)
    }

    def "Validate when valid"() {
        given:
        def constraints = [new NotNull('a'), new NotBlank('a')]

        when:
        validator.validate(jsonMergePatch, constraints)

        then:
        notThrown(BadRequestException)

        where:
        jsonMergePatch << ['{"a": "b"}', '{}', '{"b": "b"}']
    }
}
