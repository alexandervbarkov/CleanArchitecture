package com.alexandervbarkov.cleanarchitecture.configuration.customer.acceptance

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer
import com.alexandervbarkov.cleanarchitecture.commoninfrastructure.api.ErrorResponse
import org.springframework.test.annotation.DirtiesContext

import static com.alexandervbarkov.cleanarchitecture.configuration.testutil.PageUtils.buildEmptyPage
import static com.alexandervbarkov.cleanarchitecture.configuration.testutil.PageUtils.buildExpectedPage
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

class SearchCustomersAcceptanceTest extends CustomerAcceptanceTest {

    @DirtiesContext
    def 'Search Customers by individual field'() {
        given:
        def createdCustomer = saveCustomer(customer)
        saveCustomerWhichShouldNotBeIncludedInResults()

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
        buildCustomer() | 'isActive'     | customer.isActive as String
    }

    @DirtiesContext
    def 'Search Customers by all fields'() {
        given:
        def customer = saveCustomer(buildCustomer())
        saveCustomerWhichShouldNotBeIncludedInResults()

        when:
        def response = mvc.perform(
                get("/customers")
                        .queryParam('id', customer.id as String)
                        .queryParam('firstName', customer.firstName)
                        .queryParam('lastName', customer.lastName)
                        .queryParam('isActive', customer.isActive as String)
        )
                .andReturn()
                .response

        then:
        response.status == 200
        assertResponseBodyEqualsExpected(response, buildExpectedPage(customer))
    }

    def 'Search Customers with invalid fields'() {
        given:
        def expectedError = new ErrorResponse([
                "customerExample.id must be greater than or equal to 1, but was '0'",
                "customerExample.lastName cannot be blank, but was ' '",
                "customerExample.firstName cannot be blank, but was ' '"
        ])

        when:
        def response = mvc.perform(
                get("/customers")
                        .queryParam('id', 0 as String)
                        .queryParam('firstName', ' ')
                        .queryParam('lastName', ' ')
        )
                .andReturn()
                .response

        then:
        response.status == 400
        assertResponseBodyEqualsExpected(response, expectedError)
    }

    @DirtiesContext
    def 'Search Customers no matches'() {
        given:
        saveCustomer(buildCustomer())
        saveCustomerWhichShouldNotBeIncludedInResults()
        def idWhichShouldNotExist = '999'

        when:
        def response = mvc.perform(get("/customers")
                .queryParam('id', idWhichShouldNotExist))
                .andReturn()
                .response

        then:
        response.status == 200
        assertResponseBodyEqualsExpected(response, buildEmptyPage())
    }

    private Customer saveCustomerWhichShouldNotBeIncludedInResults() {
        saveCustomer(Customer.builder()
                .firstName('firstName2')
                .lastName('lastName2')
                .isActive(false)
                .build())
    }
}
