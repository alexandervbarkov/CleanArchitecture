package com.alexandervbarkov.cleanarchitecture.commoncore.mergepatch

import com.alexandervbarkov.cleanarchitecture.commoncore.config.BeanConfig
import com.alexandervbarkov.cleanarchitecture.commoncore.json.JsonsJackson
import groovy.transform.EqualsAndHashCode
import spock.lang.Specification

class MergePatchesFgeTest extends Specification {
    def mergePatches = new MergePatchesFge(new JsonsJackson(BeanConfig.objectMapper()))

    def "MergePatch"() {
        given:
        def original = new Wrapper(integer: 0, decimal: 0.1, string: 'c', bool: false, other: 'other', unchanged: 100)
        def mergePatch = '{"integer": 1, "decimal": 2.2, "string": "s", "bool": true, "other": null}'
        def expected = new Wrapper(integer: 1, decimal: 2.2, string: 's', bool: true, unchanged: 100)

        expect:
        mergePatches.mergePatch(original, mergePatch) == expected
    }

    @EqualsAndHashCode
    static class Wrapper {
        int integer
        double decimal
        String string
        boolean bool
        String other
        int unchanged
    }
}
