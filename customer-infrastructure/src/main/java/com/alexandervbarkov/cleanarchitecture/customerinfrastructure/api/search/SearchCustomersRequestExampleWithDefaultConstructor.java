package com.alexandervbarkov.cleanarchitecture.customerinfrastructure.api.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

/**
 * Jackson is not deserializing query parameters to a POJO without a no args constructor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Jacksonized
public class SearchCustomersRequestExampleWithDefaultConstructor {
    private Long id;
    private String firstName;
    private String lastName;
    private Boolean isActive;
}
