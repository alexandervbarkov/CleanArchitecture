package com.alexandervbarkov.cleanarchitecture.customer.infrastructure.gateway.search;

import com.alexandervbarkov.cleanarchitecture.common.core.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.common.core.pagination.Pageable;
import com.alexandervbarkov.cleanarchitecture.common.infrastructure.pagination.Pageables;
import com.alexandervbarkov.cleanarchitecture.common.infrastructure.pagination.Pages;
import com.alexandervbarkov.cleanarchitecture.customer.core.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.customer.core.gateway.SearchCustomersGateway;
import com.alexandervbarkov.cleanarchitecture.customer.infrastructure.jpa.CustomerEntity;
import com.alexandervbarkov.cleanarchitecture.customer.infrastructure.jpa.CustomerEntityMapper;
import com.alexandervbarkov.cleanarchitecture.customer.infrastructure.jpa.CustomerRepo;
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
