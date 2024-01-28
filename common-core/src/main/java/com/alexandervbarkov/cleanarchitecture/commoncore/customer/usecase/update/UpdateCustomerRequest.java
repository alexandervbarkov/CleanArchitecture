package com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.update;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateCustomerRequest {
    Long id;
    String customerJsonMergePatch;
}
