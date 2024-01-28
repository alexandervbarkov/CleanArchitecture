package com.alexandervbarkov.cleanarchitecture.customerinfrastructure.api.update;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.entity.Customer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.update.UpdateCustomer;
import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.update.UpdateCustomerRequest;
import com.alexandervbarkov.cleanarchitecture.customercore.usecase.update.UpdateCustomerRequestSchema;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateCustomerController {
    private final UpdateCustomer createCustomer;

    @PatchMapping("/customers/{id}")
    @Operation(requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(
                    schema = @Schema(implementation = UpdateCustomerRequestSchema.class),
                    mediaType = "application/merge-patch+json")))
    public Customer update(@PathVariable("id") Long id, @RequestBody JsonNode customerJsonMergePatch) {
        return createCustomer.update(buildRequest(id, customerJsonMergePatch));
    }

    private static UpdateCustomerRequest buildRequest(Long id, JsonNode customerJsonMergePatch) {
        return UpdateCustomerRequest.builder()
                .id(id)
                .customerJsonMergePatch(customerJsonMergePatch.toString())
                .build();
    }

}
