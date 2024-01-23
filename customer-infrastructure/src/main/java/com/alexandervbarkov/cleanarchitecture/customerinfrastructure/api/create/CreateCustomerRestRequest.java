package com.alexandervbarkov.cleanarchitecture.customerinfrastructure.api.create;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create.CreateCustomerRequest;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRestRequest implements CreateCustomerRequest {
    private String firstName;
    private String lastName;
}
