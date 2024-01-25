package com.alexandervbarkov.cleanarchitecture.customerinfrastructure.api.create;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.create.CreateCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class CreateCustomerController {
    private final CreateCustomer createCustomer;

    @PostMapping("/customers")
    @ResponseStatus(CREATED)
    public Customer create(@RequestBody CreateCustomerRestRequest request) {
        return createCustomer.create(request);
    }

}
