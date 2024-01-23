package com.alexandervbarkov.cleanarchitecture.customer.infrastructure.api.search;

import com.alexandervbarkov.cleanarchitecture.common.core.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.common.infrastructure.pagination.Pageables;
import com.alexandervbarkov.cleanarchitecture.customer.core.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.customer.core.usecase.search.SearchCustomers;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SearchCustomersController {
    private final SearchCustomers searchCustomers;

    @GetMapping("/customers")
    public Page<? extends Customer> search(Customer customer, Pageable pageable) {
        return searchCustomers.search(customer, Pageables.of(pageable));
    }

}
