package com.alexandervbarkov.cleanarchitecture.customercore.usecase.create;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create.CreateCustomerRequest;
import com.alexandervbarkov.cleanarchitecture.commoncore.validation.ModelValidator;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
class CustomerValidator {
    private final ModelValidator validator;

    void validate(CreateCustomerRequest request) {
        validator.validate(request);
    }
}
