package com.alexandervbarkov.cleanarchitecture.customerinfrastructure.gateway;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.GetCustomerByIdGateway;
import com.alexandervbarkov.cleanarchitecture.customerinfrastructure.jpa.CustomerEntityMapper;
import com.alexandervbarkov.cleanarchitecture.customerinfrastructure.jpa.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetCustomerByIdJpaGateway implements GetCustomerByIdGateway {
    private final CustomerRepo repo;
    private final CustomerEntityMapper mapper;

    @Override
    public Optional<Customer> get(Long id) {
        return repo.findById(id)
                .map(mapper::toDto);
    }
}
