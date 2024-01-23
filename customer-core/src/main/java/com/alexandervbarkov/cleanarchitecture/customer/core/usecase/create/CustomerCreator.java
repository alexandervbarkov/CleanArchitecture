package com.alexandervbarkov.cleanarchitecture.customer.core.usecase.create;

import com.alexandervbarkov.cleanarchitecture.customer.core.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.customer.core.gateway.CreateCustomerGateway;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CustomerCreator implements CreateCustomer {
    private final CreateCustomerGateway gateway;
    private final CreateCustomerRequestMapper mapper;

    @Override
    public Customer create(CreateCustomerRequest request) {
        Customer customer = mapper.toCustomer(request);
        return gateway.create(customer);
    }


}
