package com.alexandervbarkov.cleanarchitecture.customerinfrastructure.gateway.search;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Pageable;
import com.alexandervbarkov.cleanarchitecture.commoninfrastructure.pagination.Pageables;
import com.alexandervbarkov.cleanarchitecture.commoninfrastructure.pagination.Pages;
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SearchCustomersGateway;
import com.alexandervbarkov.cleanarchitecture.customerinfrastructure.jpa.CustomerEntity;
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
    public Page<? extends Customer> search(Customer customer, Pageable pageable) {
        org.springframework.data.domain.Page<CustomerEntity> page = repo.findAll(Example.of(mapper.toEntity(customer)), Pageables.of(pageable));
        return Pages.of(page, pageable);
    }
}
