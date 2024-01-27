package com.alexandervbarkov.cleanarchitecture.customerinfrastructure.gateway.save;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SaveCustomerGateway;
import com.alexandervbarkov.cleanarchitecture.customerinfrastructure.jpa.CustomerEntity;
import com.alexandervbarkov.cleanarchitecture.customerinfrastructure.jpa.CustomerEntityMapper;
import com.alexandervbarkov.cleanarchitecture.customerinfrastructure.jpa.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class SaveCustomerJpaGateway implements SaveCustomerGateway {
    private final CustomerRepo repo;
    private final CustomerEntityMapper mapper;

    @Override
    public Customer save(Customer customer) {
        return ((Function<Customer, CustomerEntity>) mapper::toEntity)
                .andThen(repo::save)
                .andThen(mapper::toDto)
                .apply(customer);
    }
}
