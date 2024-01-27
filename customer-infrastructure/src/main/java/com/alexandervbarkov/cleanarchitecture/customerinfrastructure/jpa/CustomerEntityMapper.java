package com.alexandervbarkov.cleanarchitecture.customerinfrastructure.jpa;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "jsr330")
@Component
public interface CustomerEntityMapper {
    CustomerEntity toEntity(Customer customer);

    Customer toDto(CustomerEntity entity);
}
