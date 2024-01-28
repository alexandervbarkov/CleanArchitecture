package com.alexandervbarkov.cleanarchitecture.commoninfrastructure.api;

import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.List;

import static java.util.Collections.singletonList;

@Value
@RequiredArgsConstructor
public class ErrorResponse {
    List<String> messages;

    public ErrorResponse(String message) {
        this(singletonList(message));
    }
}
