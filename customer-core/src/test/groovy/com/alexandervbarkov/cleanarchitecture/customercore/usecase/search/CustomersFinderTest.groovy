package com.alexandervbarkov.cleanarchitecture.customercore.usecase.search

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomersRequest
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomersRequestExample
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Pageable
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SearchCustomersGateway
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SearchCustomersGatewayRequest
import spock.lang.Specification

import static com.alexandervbarkov.cleanarchitecture.customercore.testutils.CustomerUtils.buildCustomer

class CustomersFinderTest extends Specification {
    SearchCustomersGateway gateway = Mock()
    def mapper = new SearchCustomersRequestMapperImpl()
    def customerFinder = new CustomersFinder(gateway, mapper)

    def "SearchCustomers"() {
        given:
        def pageable = Pageable.builder().build()
        def request = SearchCustomersRequest.builder()
                .customerExample(buildSearchCustomersRequestExampleMatchingBuildCustomer())
                .pageable(pageable)
                .build()
        def gatewayRequest = SearchCustomersGatewayRequest.builder()
                .customerExample(buildCustomer())
                .pageable(pageable)
                .build()
        def page = Page.builder().build()

        when:
        def actual = customerFinder.search(request)

        then:
        1 * gateway.search(gatewayRequest) >> page
        actual == page
    }

    private SearchCustomersRequestExample buildSearchCustomersRequestExampleMatchingBuildCustomer() {
        SearchCustomersRequestExample.builder()
                .id(1L)
                .firstName('firstName')
                .lastName('lastName')
                .isActive(true)
                .build()
    }
}
