package com.alexandervbarkov.cleanarchitecture.customer.infrastructure.api.create;

import com.alexandervbarkov.cleanarchitecture.customer.core.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.customer.core.usecase.create.CreateCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateCustomerController {
    private final CreateCustomer createCustomer;

    @PostMapping("/customers")
    public Customer create(@RequestBody CreateCustomerRestRequest request) {
        return createCustomer.create(request);
    }

}
