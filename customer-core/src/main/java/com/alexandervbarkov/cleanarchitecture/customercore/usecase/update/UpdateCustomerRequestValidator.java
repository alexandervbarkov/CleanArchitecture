package com.alexandervbarkov.cleanarchitecture.customercore.usecase.update;

import com.alexandervbarkov.cleanarchitecture.commoncore.customer.usecase.update.UpdateCustomerRequest;
import com.alexandervbarkov.cleanarchitecture.commoncore.exception.BadRequestException;
import com.alexandervbarkov.cleanarchitecture.commoncore.validation.jsonmergepatch.Constraint;
import com.alexandervbarkov.cleanarchitecture.commoncore.validation.jsonmergepatch.JsonMergePatchValidator;
import com.alexandervbarkov.cleanarchitecture.commoncore.validation.jsonmergepatch.NotBlank;
import com.alexandervbarkov.cleanarchitecture.commoncore.validation.jsonmergepatch.NotNull;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
class UpdateCustomerRequestValidator {
    private static final List<? extends Constraint> jsonMergePatchConstraints = List.of(
            new NotBlank("firstName"),
            new NotBlank("lastName"),
            new NotNull("isActive")
    );
    private final JsonMergePatchValidator validator;

    public void validate(UpdateCustomerRequest request) {
        validateId(request.getId());
        validateJsonMergePatch(request.getCustomerJsonMergePatch());
    }

    private static void validateId(Long id) {
        if (id < 1) {
            throw new BadRequestException("id must be greater than or equal to 1, but was '" + id + "'");
        }
    }

    private void validateJsonMergePatch(String jsonMergePatch) {
        validator.validate(jsonMergePatch, jsonMergePatchConstraints);
    }
}
