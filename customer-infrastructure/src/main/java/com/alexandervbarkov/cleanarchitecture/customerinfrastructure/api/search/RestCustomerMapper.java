package com.alexandervbarkov.cleanarchitecture.customerinfrastructure.api.search;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomersRequestExample;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestCustomerMapper {
    SearchCustomersRequestExample toCustomer(RestCustomer restCustomer);
}
