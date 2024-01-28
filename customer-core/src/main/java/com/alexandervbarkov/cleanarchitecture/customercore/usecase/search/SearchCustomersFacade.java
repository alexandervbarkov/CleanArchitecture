package com.alexandervbarkov.cleanarchitecture.customercore.usecase.search;

import com.alexandervbarkov.cleanarchitecture.commoncore.chainofresponsibility.ChainFacade;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomers;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomersRequest;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.customercore.usecase.search.SearchCustomersChain.CustomersFinderChain;
import com.alexandervbarkov.cleanarchitecture.customercore.usecase.search.SearchCustomersChain.SearchCustomersRequestValidatorChain;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SearchCustomersFacade extends ChainFacade<SearchCustomersRequest, Page<Customer>> implements SearchCustomers {
    @Inject
    public SearchCustomersFacade(
            SearchCustomersRequestValidatorChain searchCustomersRequestValidatorChain,
            CustomersFinderChain customerCreatorChain
    ) {
        super(
                searchCustomersRequestValidatorChain,
                customerCreatorChain
        );
    }

    @Override
    public Page<Customer> search(SearchCustomersRequest request) {
        return first.action(request);
    }
}
