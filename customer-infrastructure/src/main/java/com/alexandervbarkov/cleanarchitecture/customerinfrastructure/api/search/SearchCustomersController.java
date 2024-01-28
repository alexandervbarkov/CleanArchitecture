package com.alexandervbarkov.cleanarchitecture.customerinfrastructure.api.search;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomers;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.search.SearchCustomersRequest;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.commoninfrastructure.pagination.Pageables;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SearchCustomersController {
    private final SearchCustomers searchCustomers;
    private final SearchCustomersRequestExampleMapper mapper;

    @GetMapping("/customers")
    public Page<Customer> search(SearchCustomersRequestExampleWithDefaultConstructor customerExample, Pageable pageable) {
        return searchCustomers.search(buildRequest(customerExample, pageable));
    }

    private SearchCustomersRequest buildRequest(SearchCustomersRequestExampleWithDefaultConstructor customerExample, Pageable pageable) {
        return SearchCustomersRequest.builder()
                .customerExample(mapper.toSearchCustomersRequestExample(customerExample))
                .pageable(Pageables.of(pageable))
                .build();
    }

}
