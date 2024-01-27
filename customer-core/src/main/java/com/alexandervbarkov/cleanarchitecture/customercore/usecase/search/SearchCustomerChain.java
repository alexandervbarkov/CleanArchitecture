package com.alexandervbarkov.cleanarchitecture.customercore.usecase.search;

import com.alexandervbarkov.cleanarchitecture.commoncore.chainofresponsibility.ConsumerInChain;
import com.alexandervbarkov.cleanarchitecture.commoncore.chainofresponsibility.LastInChain;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomersRequest;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.commoncore.validation.Validator;

import javax.inject.Named;

class SearchCustomerChain {
    @Named
    public static class CustomersFinderChain extends LastInChain<SearchCustomersRequest, Page<Customer>> {
        CustomersFinderChain(CustomersFinder customersFinder) {
            super(customersFinder::search);
        }
    }

    @Named
    public static class CustomerValidatorChain extends ConsumerInChain<SearchCustomersRequest, Page<Customer>> {
        CustomerValidatorChain(Validator validator) {
            super(validator::validate);
        }
    }
}
