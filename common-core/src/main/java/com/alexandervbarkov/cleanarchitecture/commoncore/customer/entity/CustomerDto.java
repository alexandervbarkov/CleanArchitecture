package com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Builder
public class CustomerDto implements Customer {
    private final Long id;
    private final String firstName;
    private final String lastName;
}