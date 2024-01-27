package com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Customer {
    @Min(1)
    Long id;
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    Boolean isActive;
}
