package com.alexandervbarkov.cleanarchitecture.commoninfrastructure.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ErrorResponse {
    private final String message;
}