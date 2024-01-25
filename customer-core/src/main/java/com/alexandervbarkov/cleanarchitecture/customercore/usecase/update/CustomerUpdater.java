package com.alexandervbarkov.cleanarchitecture.customercore.usecase.update;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.update.UpdateCustomer;
import com.alexandervbarkov.cleanarchitecture.commoncore.exception.ResourceNotFoundException;
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.UpdateCustomerGateway;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CustomerUpdater implements UpdateCustomer {
    private static final String CANNOT_FIND_CUSTOMER_WITH_ID = "Cannot find Customer with ID: ";

    private final UpdateCustomerGateway gateway;

    @Override
    public Customer update(Long id, String customerJsonMergePatch) {
        return gateway.update(id, customerJsonMergePatch)
                .orElseThrow(() -> new ResourceNotFoundException(CANNOT_FIND_CUSTOMER_WITH_ID + id));
    }
}
