package com.alexandervbarkov.cleanarchitecture.customer.core.usecase.create;

import com.alexandervbarkov.cleanarchitecture.customer.core.entity.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.inject.Named;

@Mapper(componentModel = "jsr330")
@Named
@FunctionalInterface
public interface CreateCustomerRequestMapper {
    @Mapping(target = "id", ignore = true)
    CustomerDto toCustomer(CreateCustomerRequest customer);
}
