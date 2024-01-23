package com.alexandervbarkov.cleanarchitecture.commoncore.pagination;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class SortDto implements Sort {
    private final String property;
    private final Direction direction;
}
