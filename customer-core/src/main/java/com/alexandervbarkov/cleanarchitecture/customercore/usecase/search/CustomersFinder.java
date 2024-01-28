package com.alexandervbarkov.cleanarchitecture.customercore.usecase.search;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomers;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomersRequest;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SearchCustomersGateway;
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SearchCustomersGatewayRequest;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
class CustomersFinder implements SearchCustomers {
    private final SearchCustomersGateway gateway;
    private final SearchCustomersRequestMapper mapper;

    @Override
    public Page<Customer> search(SearchCustomersRequest request) {
        var gatewayRequest = mapToGatewayRequest(request);
        return gateway.search(gatewayRequest);
    }

    private SearchCustomersGatewayRequest mapToGatewayRequest(SearchCustomersRequest request) {
        var customerExample = mapper.toCustomer(request.getCustomerExample());
        return SearchCustomersGatewayRequest.builder()
                .customerExample(customerExample)
                .pageable(request.getPageable())
                .build();
    }
}
