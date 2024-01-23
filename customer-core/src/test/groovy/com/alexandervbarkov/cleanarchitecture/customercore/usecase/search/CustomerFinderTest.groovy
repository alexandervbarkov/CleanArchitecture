package com.alexandervbarkov.cleanarchitecture.customercore.usecase.search

import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Pageable
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SearchCustomersGateway
import spock.lang.Specification

import static com.alexandervbarkov.cleanarchitecture.customercore.testutils.CustomerUtils.buildCustomer

class CustomerFinderTest extends Specification {
    SearchCustomersGateway gateway = Mock()
    def customerFinder = new CustomerFinder(gateway)

    def "SearchCustomers"() {
        given:
        Pageable pageable = Mock()
        Page page = Mock()

        when:
        def actual = customerFinder.search(buildCustomer(), pageable)

        then:
        1 * gateway.search(buildCustomer(), pageable) >> page
        actual == page
    }
}
