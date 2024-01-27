package com.alexandervbarkov.cleanarchitecture.configuration.customer.acceptance

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer
import org.springframework.test.annotation.DirtiesContext

import static com.alexandervbarkov.cleanarchitecture.configuration.testutil.PageUtils.buildEmptyPage
import static com.alexandervbarkov.cleanarchitecture.configuration.testutil.PageUtils.buildExpectedPage
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

class SearchCustomersAcceptanceTest extends CustomerAcceptanceTest {

    @DirtiesContext
    def 'Search Customers by individual field'() {
        given:
        def createdCustomer = createCustomer(customer)
        createCustomer(Customer.builder()
                .firstName('firstName2')
                .lastName('lastName2')
                .isActive(false)
                .build())

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
        def customer = createCustomer(buildCustomer())
        createCustomer(Customer.builder()
                .firstName('firstName2')
                .lastName('lastName2')
                .isActive(false)
                .build())

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

    @DirtiesContext
    def 'Search Customers no matches'() {
        given:
        createCustomer(buildCustomer())
        createCustomer(Customer.builder()
                .firstName('firstName2')
                .lastName('lastName2')
                .isActive(false)
                .build())

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
