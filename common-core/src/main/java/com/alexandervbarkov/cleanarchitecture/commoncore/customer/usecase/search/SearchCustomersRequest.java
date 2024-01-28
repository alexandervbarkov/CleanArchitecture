package com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search;

import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Pageable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class SearchCustomersRequest {
    @Valid
    @NotNull
    SearchCustomersRequestExample customerExample;
    @Valid
    @NotNull
    Pageable pageable;
}
