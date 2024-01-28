package com.alexandervbarkov.cleanarchitecture.customercore.usecase.search;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomersRequestExample;
import org.mapstruct.Mapper;

import javax.inject.Named;

@Mapper(componentModel = "jsr330")
@Named
public interface SearchCustomersRequestMapper {
    Customer toCustomer(SearchCustomersRequestExample customerExample);
}
