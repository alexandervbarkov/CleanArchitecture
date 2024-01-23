package com.alexandervbarkov.cleanarchitecture.customer.core.usecase.search;

import com.alexandervbarkov.cleanarchitecture.common.core.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.common.core.pagination.Pageable;
import com.alexandervbarkov.cleanarchitecture.customer.core.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.customer.core.gateway.SearchCustomersGateway;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CustomerFinder implements SearchCustomers {
    private final SearchCustomersGateway gateway;

    @Override
    public Page<? extends Customer> search(Customer customerExample, Pageable pageable) {
        return gateway.search(customerExample, pageable);
    }
}
