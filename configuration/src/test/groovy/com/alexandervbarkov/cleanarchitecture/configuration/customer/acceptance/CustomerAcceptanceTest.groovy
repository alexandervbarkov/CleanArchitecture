package com.alexandervbarkov.cleanarchitecture.configuration.customer.acceptance

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Pageable
import com.alexandervbarkov.cleanarchitecture.configuration.AcceptanceTest
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SaveCustomerGateway
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SearchCustomersGateway
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SearchCustomersGatewayRequest
import org.springframework.beans.factory.annotation.Autowired

abstract class CustomerAcceptanceTest extends AcceptanceTest {
    @Autowired
    private SaveCustomerGateway saveCustomerGateway

    @Autowired
    private SearchCustomersGateway searchCustomersGateway

    protected Customer saveCustomer(Customer customer) {
        saveCustomerGateway.save(customer)
    }

    protected void assertCustomerExistsInDb(Customer expectedCustomer) {
        def customersInDb = searchCustomers(expectedCustomer)
        assert customersInDb.size() == 1
        assert expectedCustomer == customersInDb[0]
    }

    protected List<Customer> searchCustomers(Customer customerExample) {
        def request = SearchCustomersGatewayRequest.builder()
                .customerExample(customerExample)
                .pageable(Pageable.builder().build())
                .build()
        searchCustomersGateway.search(request).content
    }

    protected Customer buildCustomer() {
        Customer.builder()
                .id(1L)
                .firstName('firstName')
                .lastName('lastName')
                .isActive(true)
                .build()
    }
}
