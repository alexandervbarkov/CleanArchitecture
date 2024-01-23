package com.alexandervbarkov.cleanarchitecture.customer.core.usecase.search;

import com.alexandervbarkov.cleanarchitecture.common.core.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.common.core.pagination.Pageable;
import com.alexandervbarkov.cleanarchitecture.customer.core.entity.Customer;

public interface SearchCustomers {
    Page<? extends Customer> search(Customer customerExample, Pageable pageable);
}
