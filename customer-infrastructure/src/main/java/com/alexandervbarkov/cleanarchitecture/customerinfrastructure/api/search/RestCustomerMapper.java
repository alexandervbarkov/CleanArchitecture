package com.alexandervbarkov.cleanarchitecture.customerinfrastructure.api.search;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestCustomerMapper {
    Customer toCustomer(RestCustomer restCustomer);
}
