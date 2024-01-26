package com.alexandervbarkov.cleanarchitecture.commoninfrastructure.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static java.util.Collections.singletonList;

@Data
@RequiredArgsConstructor
public class ErrorResponse {
    private final List<String> messages;

    public ErrorResponse(String message) {
        this(singletonList(message));
    }
}
