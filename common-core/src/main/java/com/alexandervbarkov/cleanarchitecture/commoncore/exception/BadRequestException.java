package com.alexandervbarkov.cleanarchitecture.commoncore.exception;

import lombok.*;

import java.util.List;

import static java.util.Collections.singletonList;

@Value
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BadRequestException extends RuntimeException {
    List<String> messages;

    public BadRequestException(String message) {
        this(singletonList(message));
    }
}
