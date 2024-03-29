package com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class CreateCustomerRequest {
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @NotNull
    Boolean isActive;
}
