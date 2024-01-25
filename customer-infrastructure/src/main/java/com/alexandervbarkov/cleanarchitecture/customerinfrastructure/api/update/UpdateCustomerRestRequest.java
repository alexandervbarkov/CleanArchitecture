package com.alexandervbarkov.cleanarchitecture.customerinfrastructure.api.update;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create.CreateCustomerRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRestRequest implements CreateCustomerRequest {
    private String firstName;
    private String lastName;
}
