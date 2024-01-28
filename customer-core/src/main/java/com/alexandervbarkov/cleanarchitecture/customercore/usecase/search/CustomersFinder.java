package com.alexandervbarkov.cleanarchitecture.customercore.usecase.search;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomers;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomersRequest;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SearchCustomersGateway;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
class CustomersFinder implements SearchCustomers {
    private final SearchCustomersGateway gateway;

    @Override
    public Page<Customer> search(SearchCustomersRequest request) {
        return gateway.search(request);
    }
}
