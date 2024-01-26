package com.alexandervbarkov.cleanarchitecture.commoncore.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static java.util.Collections.singletonList;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BadRequestException extends RuntimeException {
    private final List<String> messages;

    public BadRequestException(String message) {
        this(singletonList(message));
    }
}
