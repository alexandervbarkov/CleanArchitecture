package com.alexandervbarkov.cleanarchitecture.customercore.gateway;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Pageable;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SearchCustomersGatewayRequest {
    Customer customerExample;
    Pageable pageable;
}
