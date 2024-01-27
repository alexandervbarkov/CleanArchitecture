package com.alexandervbarkov.cleanarchitecture.customercore.gateway;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;

import java.util.Optional;

@FunctionalInterface
public interface UpdateCustomerGateway {
    Optional<Customer> update(Long id, String customerJsonMergePatch);
}
