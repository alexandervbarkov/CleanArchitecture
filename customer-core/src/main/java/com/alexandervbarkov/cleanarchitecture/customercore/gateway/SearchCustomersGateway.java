package com.alexandervbarkov.cleanarchitecture.customercore.gateway;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Pageable;

@FunctionalInterface
public interface SearchCustomersGateway {
    Page<Customer> search(Customer customer, Pageable pageable);
}
