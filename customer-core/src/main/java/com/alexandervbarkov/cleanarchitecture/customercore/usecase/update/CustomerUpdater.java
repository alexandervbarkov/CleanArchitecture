package com.alexandervbarkov.cleanarchitecture.customercore.usecase.update;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.update.UpdateCustomer;
import com.alexandervbarkov.cleanarchitecture.commoncore.exception.ResourceNotFoundException;
import com.alexandervbarkov.cleanarchitecture.commoncore.mergepatch.MergePatches;
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.GetCustomerByIdGateway;
import com.alexandervbarkov.cleanarchitecture.customercore.gateway.SaveCustomerGateway;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CustomerUpdater implements UpdateCustomer {
    private static final String CANNOT_FIND_CUSTOMER_WITH_ID = "Cannot find Customer with ID: ";
    private final GetCustomerByIdGateway getCustomerById;
    private final SaveCustomerGateway saveCustomerGateway;
    private final MergePatches mergePatches;

    @Override
    public Customer update(Long id, String customerJsonMergePatch) {
        var currentCustomer = getCurrentCustomer(id);
        var patchedCustomer = patchCustomer(currentCustomer, customerJsonMergePatch);
        return saveCustomer(patchedCustomer);
    }

    private Customer getCurrentCustomer(Long id) {
        return getCustomerById.get(id)
                .orElseThrow(() -> new ResourceNotFoundException(CANNOT_FIND_CUSTOMER_WITH_ID + id));
    }

    private Customer patchCustomer(Customer currentCustomer, String customerJsonMergePatch) {
        return mergePatches.mergePatch(currentCustomer, customerJsonMergePatch);
    }

    private Customer saveCustomer(Customer patchedCustomer) {
        return saveCustomerGateway.save(patchedCustomer);
    }
}
