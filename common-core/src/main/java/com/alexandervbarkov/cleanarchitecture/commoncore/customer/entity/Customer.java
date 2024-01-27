package com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity;

import com.alexandervbarkov.cleanarchitecture.commoncore.validation.annotation.NotBlankNullable;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Customer {
    @Min(1)
    Long id;
    @NotBlankNullable
    String firstName;
    @NotBlankNullable
    String lastName;
    Boolean isActive;
}
