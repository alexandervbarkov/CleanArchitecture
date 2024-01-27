package com.alexandervbarkov.cleanarchitecture.customercore.usecase.search;

import com.alexandervbarkov.cleanarchitecture.commoncore.chainofresponsibility.ChainFacade;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomers;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomersRequest;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SearchCustomerFacade extends ChainFacade<SearchCustomersRequest, Page<Customer>> implements SearchCustomers {
    @Inject
    public SearchCustomerFacade(
            SearchCustomerChain.CustomerValidatorChain customerValidatorChain,
            SearchCustomerChain.CustomersFinderChain customerCreatorChain
    ) {
        super(
                customerValidatorChain,
                customerCreatorChain
        );
    }

    @Override
    public Page<Customer> search(SearchCustomersRequest request) {
        return first.action(request);
    }
}
