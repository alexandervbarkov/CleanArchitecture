package com.alexandervbarkov.cleanarchitecture.configuration.customer.testutil

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.CustomerDto


class CustomerUtils {
    static Customer buildCustomer() {
        CustomerDto.builder()
                .id(1)
                .firstName('firstName')
                .lastName('lastName')
                .build()
    }
}
