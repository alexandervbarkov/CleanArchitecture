package com.alexandervbarkov.cleanarchitecture.customercore.usecase.search

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomersRequest
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page
import com.alexandervbarkov.cleanarchitecture.commoncore.validation.object.Validator
import spock.lang.Specification

class SearchCustomersFacadeTest extends Specification {
    Validator validator = Mock()
    CustomersFinder finder = Mock()
    def facade = new SearchCustomersFacade(
            new SearchCustomersChain.SearchCustomersRequestValidatorChain(validator),
            new SearchCustomersChain.CustomersFinderChain(finder)
    )

    def "Search Customers Facade"() {
        given:
        SearchCustomersRequest request = SearchCustomersRequest.builder().build()
        Page expected = Page.builder().build()

        when:
        def actual = facade.search(request)

        then:
        1 * validator.validate(request)
        1 * finder.search(request) >> expected
        actual == expected
    }
}
