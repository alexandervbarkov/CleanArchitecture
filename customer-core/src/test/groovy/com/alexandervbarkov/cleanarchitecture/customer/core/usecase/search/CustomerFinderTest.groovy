package com.alexandervbarkov.cleanarchitecture.customer.core.usecase.search

import com.alexandervbarkov.cleanarchitecture.common.core.pagination.Page
import com.alexandervbarkov.cleanarchitecture.common.core.pagination.Pageable
import com.alexandervbarkov.cleanarchitecture.customer.core.gateway.SearchCustomersGateway
import spock.lang.Specification

import static com.alexandervbarkov.cleanarchitecture.customer.testutil.CustomerUtils.buildCustomer

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
