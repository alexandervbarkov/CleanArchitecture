package com.alexandervbarkov.cleanarchitecture.customer.infrastructure.jpa;

import com.alexandervbarkov.cleanarchitecture.customer.core.entity.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "jsr330")
@Component
@FunctionalInterface
public interface CustomerEntityMapper {
    CustomerEntity toEntity(Customer customer);
}
