package com.alexandervbarkov.cleanarchitecture.customer.core.usecase.create;

import com.alexandervbarkov.cleanarchitecture.customer.core.entity.Customer;

@FunctionalInterface
public interface CreateCustomer {
    Customer create(CreateCustomerRequest request);
}
