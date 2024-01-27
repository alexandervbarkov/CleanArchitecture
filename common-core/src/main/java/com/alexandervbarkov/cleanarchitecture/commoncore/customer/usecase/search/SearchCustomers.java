package com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Pageable;

@FunctionalInterface
public interface SearchCustomers {
    Page<Customer> search(Customer customerExample, Pageable pageable);
}
