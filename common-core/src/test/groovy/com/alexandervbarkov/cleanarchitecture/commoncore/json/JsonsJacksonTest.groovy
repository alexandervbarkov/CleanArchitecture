package com.alexandervbarkov.cleanarchitecture.commoncore.json

import com.alexandervbarkov.cleanarchitecture.commoncore.config.BeanConfig
import groovy.transform.EqualsAndHashCode
import org.skyscreamer.jsonassert.JSONAssert
import spock.lang.Specification

class JsonsJacksonTest extends Specification {
    def jsons = new JsonsJackson(BeanConfig.objectMapper())

    def "ToJson"() {
        given:
        def object = new Wrapper(integer: 1, decimal: 2.2, string: 's', bool: true)
        def expected = '{"integer": 1, "decimal": 2.2, "string": "s", "bool": true}'

        when:
        def actual = jsons.toJson(object)

        then:
        JSONAssert.assertEquals(expected, actual, false)
    }

    def "ToObject"() {
        given:
        def json = '{"integer": 1, "decimal": 2.2, "string": "s", "bool": true}'
        def expected = new Wrapper(integer: 1, decimal: 2.2, string: 's', bool: true)

        expect:
        jsons.toObject(json, Wrapper) == expected
    }

    @EqualsAndHashCode
    static class Wrapper {
        int integer
        double decimal
        String string
        boolean bool
    }
}
