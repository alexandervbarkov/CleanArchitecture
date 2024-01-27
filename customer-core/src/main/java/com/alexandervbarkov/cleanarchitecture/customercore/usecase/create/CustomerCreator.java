package com.alexandervbarkov.cleanarchitecture.customercore.usecase.create;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create.CreateCustomer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create.CreateCustomerRequest;
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SaveCustomerGateway;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
class CustomerCreator implements CreateCustomer {
    private final SaveCustomerGateway gateway;
    private final CreateCustomerRequestMapper mapper;

    @Override
    public Customer create(CreateCustomerRequest request) {
        Customer customer = mapper.toCustomer(request);
        return gateway.save(customer);
    }
}
