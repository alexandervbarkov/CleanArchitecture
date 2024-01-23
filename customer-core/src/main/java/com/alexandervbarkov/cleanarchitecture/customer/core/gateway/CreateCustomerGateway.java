package com.alexandervbarkov.cleanarchitecture.customer.core.gateway;

import com.alexandervbarkov.cleanarchitecture.customer.core.entity.Customer;

@FunctionalInterface
public interface CreateCustomerGateway {
    Customer create(Customer request);
}
