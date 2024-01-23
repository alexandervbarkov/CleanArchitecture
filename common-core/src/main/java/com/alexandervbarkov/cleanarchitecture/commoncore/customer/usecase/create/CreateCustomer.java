package com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;

@FunctionalInterface
public interface CreateCustomer {
    Customer create(CreateCustomerRequest request);
}
