package com.alexandervbarkov.cleanarchitecture.customercore.usecase.create;

import com.alexandervbarkov.cleanarchitecture.commoncore.chainofresponsibility.ChainFacade;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create.CreateCustomer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create.CreateCustomerRequest;
import com.alexandervbarkov.cleanarchitecture.customercore.usecase.create.CreateCustomerChain.CreateCustomerRequestValidatorChain;
import com.alexandervbarkov.cleanarchitecture.customercore.usecase.create.CreateCustomerChain.CustomerCreatorChain;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CreateCustomerFacade extends ChainFacade<CreateCustomerRequest, Customer> implements CreateCustomer {
    @Inject
    public CreateCustomerFacade(
            CreateCustomerRequestValidatorChain createCustomerRequestValidatorChain,
            CustomerCreatorChain customerCreatorChain
    ) {
        super(
                createCustomerRequestValidatorChain,
                customerCreatorChain
        );
    }

    @Override
    public Customer create(CreateCustomerRequest request) {
        return first.action(request);
    }
}
