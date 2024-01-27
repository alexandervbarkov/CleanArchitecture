package com.alexandervbarkov.cleanarchitecture.customercore.gateway;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;

import java.util.Optional;

@FunctionalInterface
public interface GetCustomerByIdGateway {
    Optional<Customer> get(Long id);
}
