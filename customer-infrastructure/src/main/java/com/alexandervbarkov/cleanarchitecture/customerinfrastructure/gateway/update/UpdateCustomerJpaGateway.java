package com.alexandervbarkov.cleanarchitecture.customerinfrastructure.gateway.update;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoninfrastructure.json.Jsons;
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.UpdateCustomerGateway;
import com.alexandervbarkov.cleanarchitecture.customerinfrastructure.jpa.CustomerEntity;
import com.alexandervbarkov.cleanarchitecture.customerinfrastructure.jpa.CustomerEntityMapper;
import com.alexandervbarkov.cleanarchitecture.customerinfrastructure.jpa.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UpdateCustomerJpaGateway implements UpdateCustomerGateway {
    private final CustomerRepo repo;
    private final Jsons jsons;
    private final CustomerEntityMapper mapper;

    @Override
    public Optional<Customer> update(Long id, String customerJsonMergePatch) {
        return repo.findById(id)
                .map(customer -> patchCustomer(customer, customerJsonMergePatch));
    }

    private Customer patchCustomer(CustomerEntity customer, String customerJsonMergePatch) {
        var patchedCustomer = jsons.mergePatch(customer, customerJsonMergePatch);
        CustomerEntity customerEntity = repo.save(patchedCustomer);
        return mapper.toDto(customerEntity);
    }
}
