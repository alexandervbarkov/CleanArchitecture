package com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page;

@FunctionalInterface
public interface SearchCustomers {
    Page<Customer> search(SearchCustomersRequest request);
}
