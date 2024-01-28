package com.alexandervbarkov.cleanarchitecture.customercore.usecase.update;

import com.alexandervbarkov.cleanarchitecture.commoncore.chainofresponsibility.ChainFacade;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.update.UpdateCustomer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.update.UpdateCustomerRequest;
import com.alexandervbarkov.cleanarchitecture.customercore.usecase.update.UpdateCustomerChain.CustomerUpdaterChain;
import com.alexandervbarkov.cleanarchitecture.customercore.usecase.update.UpdateCustomerChain.UpdateCustomerRequestValidatorChain;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UpdateCustomerFacade extends ChainFacade<UpdateCustomerRequest, Customer> implements UpdateCustomer {
    @Inject
    public UpdateCustomerFacade(
            UpdateCustomerRequestValidatorChain updateCustomerRequestValidatorChain,
            CustomerUpdaterChain customerUpdaterChain
    ) {
        super(
                updateCustomerRequestValidatorChain,
                customerUpdaterChain
        );
    }

    @Override
    public Customer update(UpdateCustomerRequest request) {
        return first.action(request);
    }
}
