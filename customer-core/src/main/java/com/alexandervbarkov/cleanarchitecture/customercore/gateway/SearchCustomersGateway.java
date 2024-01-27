package com.alexandervbarkov.cleanarchitecture.customercore.gateway;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomersRequest;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page;

@FunctionalInterface
public interface SearchCustomersGateway {
    Page<Customer> search(SearchCustomersRequest request);
}
