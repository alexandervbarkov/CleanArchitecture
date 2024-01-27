package com.alexandervbarkov.cleanarchitecture.commoncore.pagination;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Sort {
    String property;
    Direction direction;
}
