package com.alexandervbarkov.cleanarchitecture.customercore.usecase.update;

import com.alexandervbarkov.cleanarchitecture.commoncore.chainofresponsibility.ConsumerInChain;
import com.alexandervbarkov.cleanarchitecture.commoncore.chainofresponsibility.LastInChain;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.update.UpdateCustomerRequest;

import javax.inject.Named;

class UpdateCustomerChain {
    @Named
    public static class CustomerUpdaterChain extends LastInChain<UpdateCustomerRequest, Customer> {
        CustomerUpdaterChain(CustomerUpdater customerUpdater) {
            super(customerUpdater::update);
        }
    }

    @Named
    public static class UpdateCustomerRequestValidatorChain extends ConsumerInChain<UpdateCustomerRequest, Customer> {
        UpdateCustomerRequestValidatorChain(UpdateCustomerRequestValidator validator) {
            super(validator::validate);
        }
    }
}
