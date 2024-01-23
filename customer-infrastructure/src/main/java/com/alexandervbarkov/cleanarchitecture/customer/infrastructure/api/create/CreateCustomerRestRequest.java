package com.alexandervbarkov.cleanarchitecture.customer.infrastructure.api.create;

import com.alexandervbarkov.cleanarchitecture.customer.core.usecase.create.CreateCustomerRequest;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class CreateCustomerRestRequest implements CreateCustomerRequest {
    private final String firstName;
    private final String lastName;
}
