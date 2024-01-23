package com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search;

import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Pageable;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;

public interface SearchCustomers {
    Page<? extends Customer> search(Customer customerExample, Pageable pageable);
}