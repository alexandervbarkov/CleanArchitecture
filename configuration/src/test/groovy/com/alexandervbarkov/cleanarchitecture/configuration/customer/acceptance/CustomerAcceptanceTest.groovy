package com.alexandervbarkov.cleanarchitecture.configuration.customer.acceptance

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.PageableDto
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.CreateCustomerGateway
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SearchCustomersGateway
import com.alexandervbarkov.cleanarchitecture.customerinfrastructure.jpa.CustomerEntityMapper
import com.alexandervbarkov.cleanarchitecture.configuration.testutil.AcceptanceTest
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
