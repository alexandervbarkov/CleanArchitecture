package com.alexandervbarkov.cleanarchitecture.customercore.testutils


import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer

class CustomerUtils {
    static Customer buildCustomer() {
        Customer.builder()
                .id(1L)
                .firstName('firstName')
                .lastName('lastName')
                .isActive(true)
                .build()
    }
}
