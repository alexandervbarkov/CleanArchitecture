package com.alexandervbarkov.cleanarchitecture.customercore.gateway;


import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;

@FunctionalInterface
public interface SaveCustomerGateway {
    Customer save(Customer customer);
}
