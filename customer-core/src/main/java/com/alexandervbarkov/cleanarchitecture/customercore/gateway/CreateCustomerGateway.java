package com.alexandervbarkov.cleanarchitecture.customercore.gateway;


import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;

@FunctionalInterface
public interface CreateCustomerGateway {
    Customer create(Customer request);
}
