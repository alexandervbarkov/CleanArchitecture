package com.alexandervbarkov.cleanarchitecture.customercore.usecase.search;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomers;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Pageable;
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SearchCustomersGateway;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CustomerFinder implements SearchCustomers {
    private final SearchCustomersGateway gateway;

    @Override
    public Page<Customer> search(Customer customerExample, Pageable pageable) {
        return gateway.search(customerExample, pageable);
    }
}
