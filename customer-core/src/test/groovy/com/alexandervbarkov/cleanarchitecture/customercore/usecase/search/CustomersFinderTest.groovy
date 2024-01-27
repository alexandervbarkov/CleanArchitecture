package com.alexandervbarkov.cleanarchitecture.customercore.usecase.search

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomersRequest
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Pageable
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SearchCustomersGateway
import spock.lang.Specification

import static com.alexandervbarkov.cleanarchitecture.customercore.testutils.CustomerUtils.buildCustomer

class CustomersFinderTest extends Specification {
    SearchCustomersGateway gateway = Mock()
    def customerFinder = new CustomersFinder(gateway)

    def "SearchCustomers"() {
        given:
        Pageable pageable = Mock()
        Page page = Mock()
        def request = SearchCustomersRequest.builder()
                .customerExample(buildCustomer())
                .pageable(pageable)
                .build()

        when:
        def actual = customerFinder.search(request)

        then:
        1 * gateway.search(request) >> page
        actual == page
    }
}
