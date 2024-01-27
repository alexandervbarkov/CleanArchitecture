package com.alexandervbarkov.cleanarchitecture.customerinfrastructure.gateway;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomersRequest;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.commoninfrastructure.pagination.Pageables;
import com.alexandervbarkov.cleanarchitecture.commoninfrastructure.pagination.Pages;
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SearchCustomersGateway;
import com.alexandervbarkov.cleanarchitecture.customerinfrastructure.jpa.CustomerEntityMapper;
import com.alexandervbarkov.cleanarchitecture.customerinfrastructure.jpa.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SearchCustomerJpaGateway implements SearchCustomersGateway {
    private final CustomerRepo repo;
    private final CustomerEntityMapper mapper;

    @Override
    public Page<Customer> search(SearchCustomersRequest request) {
        var results = repo.findAll(
                Example.of(mapper.toEntity(request.getCustomerExample())),
                Pageables.of(request.getPageable())
        );
        return Pages.of(results, request.getPageable(), mapper::toDto);
    }
}
