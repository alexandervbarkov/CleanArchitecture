package com.alexandervbarkov.cleanarchitecture.customercore.usecase.search;

import com.alexandervbarkov.cleanarchitecture.commoncore.chainofresponsibility.ConsumerInChain;
import com.alexandervbarkov.cleanarchitecture.commoncore.chainofresponsibility.LastInChain;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomersRequest;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.commoncore.validation.object.Validator;

import javax.inject.Named;

class SearchCustomersChain {
    @Named
    public static class CustomersFinderChain extends LastInChain<SearchCustomersRequest, Page<Customer>> {
        CustomersFinderChain(CustomersFinder customersFinder) {
            super(customersFinder::search);
        }
    }

    @Named
    public static class SearchCustomersRequestValidatorChain extends ConsumerInChain<SearchCustomersRequest, Page<Customer>> {
        SearchCustomersRequestValidatorChain(Validator validator) {
            super(validator::validate);
        }
    }
}
