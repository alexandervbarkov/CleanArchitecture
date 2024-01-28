package com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Customer {
    Long id;
    String firstName;
    String lastName;
    Boolean isActive;
}
