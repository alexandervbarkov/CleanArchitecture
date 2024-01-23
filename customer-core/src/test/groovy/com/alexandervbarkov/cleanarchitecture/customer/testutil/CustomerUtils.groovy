package com.alexandervbarkov.cleanarchitecture.customer.testutil

import com.alexandervbarkov.cleanarchitecture.customer.core.entity.Customer
import com.alexandervbarkov.cleanarchitecture.customer.core.entity.CustomerDto

class CustomerUtils {
    static Customer buildCustomer() {
        CustomerDto.builder()
                .id(1)
                .firstName('firstName')
                .lastName('lastName')
                .build()
    }
}
