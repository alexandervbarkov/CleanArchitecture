package com.alexandervbarkov.cleanarchitecture.customer.core.gateway;

import com.alexandervbarkov.cleanarchitecture.common.core.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.common.core.pagination.Pageable;
import com.alexandervbarkov.cleanarchitecture.customer.core.entity.Customer;

@FunctionalInterface
public interface SearchCustomersGateway {
    Page<? extends Customer> search(Customer customer, Pageable pageable);
}
