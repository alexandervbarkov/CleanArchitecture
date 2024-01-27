package com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class UpdateCustomerRequest {
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @NotNull
    Boolean isActive;
}
