package com.alexandervbarkov.cleanarchitecture.customer.acceptance

import static com.alexandervbarkov.cleanarchitecture.customer.testutil.CustomerUtils.buildCustomer
import static com.alexandervbarkov.cleanarchitecture.testutil.PageUtils.buildEmptyPage
import static com.alexandervbarkov.cleanarchitecture.testutil.PageUtils.buildExpectedPage
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

class SearchCustomersAcceptanceTest extends CustomerAcceptanceTest {

    def 'Search Customers by individual field'() {
        given:
        def createdCustomer = createCustomer(customer)

        when:
        def response = mvc.perform(
                get("/customers")
                        .queryParam(queryParamName, queryParamValue)
        )
                .andReturn()
                .response

        then:
        response.status == 200
        assertResponseBodyEqualsExpected(response, buildExpectedPage(createdCustomer))

        where:
        customer        | queryParamName | queryParamValue
        buildCustomer() | 'firstName'    | customer.firstName
        buildCustomer() | 'lastName'     | customer.lastName
        buildCustomer() | 'id'           | customer.id as String
    }

    def 'Search Customers by all fields'() {
        given:
        def customer = createCustomer(buildCustomer())

        when:
        def response = mvc.perform(
                get("/customers")
                        .queryParam('id', customer.id as String)
                        .queryParam('firstName', customer.firstName)
                        .queryParam('lastName', customer.lastName)
        )
                .andReturn()
                .response

        then:
        response.status == 200
        assertResponseBodyEqualsExpected(response, buildExpectedPage(customer))
    }

    def 'Search Customers no matches'() {
        given:
        createCustomer(buildCustomer())

        when:
        def response = mvc.perform(get("/customers")
                .queryParam('id', '0'))
                .andReturn()
                .response

        then:
        response.status == 200
        assertResponseBodyEqualsExpected(response, buildEmptyPage())
    }
}
