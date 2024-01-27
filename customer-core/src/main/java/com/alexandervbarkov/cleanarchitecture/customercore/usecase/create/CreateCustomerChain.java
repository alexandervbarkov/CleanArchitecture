package com.alexandervbarkov.cleanarchitecture.customercore.usecase.create;

import com.alexandervbarkov.cleanarchitecture.commoncore.chainofresponsibility.ConsumerInChain;
import com.alexandervbarkov.cleanarchitecture.commoncore.chainofresponsibility.LastInChain;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create.CreateCustomerRequest;
import com.alexandervbarkov.cleanarchitecture.commoncore.validation.Validator;

import javax.inject.Named;

class CreateCustomerChain {
    @Named
    public static class CustomerCreatorChain extends LastInChain<CreateCustomerRequest, Customer> {
        CustomerCreatorChain(CustomerCreator customerCreator) {
            super(customerCreator::create);
        }
    }

    @Named
    public static class CustomerValidatorChain extends ConsumerInChain<CreateCustomerRequest, Customer> {
        CustomerValidatorChain(Validator validator) {
            super(validator::validate);
        }
    }
}
