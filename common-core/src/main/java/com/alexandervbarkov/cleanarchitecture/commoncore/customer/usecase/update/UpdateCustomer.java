package com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.update;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;

@FunctionalInterface
public interface UpdateCustomer {
    Customer update(Long id, String customerJsonMergePatch);
}
