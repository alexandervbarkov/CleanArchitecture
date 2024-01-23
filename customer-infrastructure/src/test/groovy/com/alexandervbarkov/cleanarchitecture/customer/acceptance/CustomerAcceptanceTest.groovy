package com.alexandervbarkov.cleanarchitecture.customer.acceptance

import com.alexandervbarkov.cleanarchitecture.common.core.pagination.PageableDto
import com.alexandervbarkov.cleanarchitecture.customer.core.entity.Customer
import com.alexandervbarkov.cleanarchitecture.customer.core.gateway.CreateCustomerGateway
import com.alexandervbarkov.cleanarchitecture.customer.core.gateway.SearchCustomersGateway
import com.alexandervbarkov.cleanarchitecture.customer.infrastructure.jpa.CustomerEntityMapper
import com.alexandervbarkov.cleanarchitecture.testutil.AcceptanceTest
import org.springframework.beans.factory.annotation.Autowired

abstract class CustomerAcceptanceTest extends AcceptanceTest {
    @Autowired
    private CreateCustomerGateway createCustomerGateway

    @Autowired
    private SearchCustomersGateway searchCustomersGateway

    @Autowired
    private CustomerEntityMapper entityMapper

    protected Customer createCustomer(Customer customer) {
        createCustomerGateway.create(customer)
    }

    protected List<? extends Customer> searchCustomers(Customer customerExample) {
        searchCustomersGateway.search(customerExample, new PageableDto()).content
    }

    protected void assertCustomerExistsInDb(Customer expectedCustomer) {
        def customersInDb = searchCustomers(expectedCustomer)
        assert customersInDb.size() == 1
        assert entityMapper.toEntity(expectedCustomer) == customersInDb[0]
    }
}
