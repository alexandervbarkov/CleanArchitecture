package com.alexandervbarkov.cleanarchitecture.customercore.usecase.create;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.CustomerDto;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create.CreateCustomerRequest;
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
