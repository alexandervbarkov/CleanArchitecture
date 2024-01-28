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
    private final RestCustomerMapper mapper;

    @GetMapping("/customers")
    public Page<Customer> search(RestCustomer customerExample, Pageable pageable) {
        // TODO figure out why SearchCustomersRequestExample is not being deserialized, even though the @Jacksonize is present,
        // as is in the other models. As a workaround, the RestCustomer was created with a default constructor.
        return searchCustomers.search(buildRequest(customerExample, pageable));
    }

    private SearchCustomersRequest buildRequest(RestCustomer customerExample, Pageable pageable) {
        return SearchCustomersRequest.builder()
                .customerExample(mapper.toCustomer(customerExample))
                .pageable(Pageables.of(pageable))
                .build();
    }

}
