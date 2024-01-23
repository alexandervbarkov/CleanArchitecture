package com.alexandervbarkov.cleanarchitecture.customer.infrastructure.gateway.create;

import com.alexandervbarkov.cleanarchitecture.customer.core.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.customer.core.gateway.CreateCustomerGateway;
import com.alexandervbarkov.cleanarchitecture.customer.infrastructure.jpa.CustomerEntity;
import com.alexandervbarkov.cleanarchitecture.customer.infrastructure.jpa.CustomerEntityMapper;
import com.alexandervbarkov.cleanarchitecture.customer.infrastructure.jpa.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateCustomerJpaGateway implements CreateCustomerGateway {
    private final CustomerRepo repo;
    private final CustomerEntityMapper mapper;

    @Override
    public Customer create(Customer request) {
        CustomerEntity customer = mapper.toEntity(request);
        return repo.save(customer);
    }
}
