package com.alexandervbarkov.cleanarchitecture.customercore.usecase.create;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create.CreateCustomerRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class CreateCustomerRequestDto implements CreateCustomerRequest {
    @NotBlank
    private final String firstName;
    @NotBlank
    private final String lastName;
}
