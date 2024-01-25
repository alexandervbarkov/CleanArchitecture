package com.alexandervbarkov.cleanarchitecture.customercore.gateway;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;

import java.util.Optional;

public interface UpdateCustomerGateway {
    Optional<? extends Customer> update(Long id, String customerJsonMergePatch);
}
