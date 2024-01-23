package com.alexandervbarkov.cleanarchitecture.common.infrastructure.pagination;

import com.alexandervbarkov.cleanarchitecture.common.core.pagination.Direction;
import org.springframework.data.domain.Sort;

import static com.alexandervbarkov.cleanarchitecture.common.core.pagination.Direction.ASC;
import static com.alexandervbarkov.cleanarchitecture.common.core.pagination.Direction.DESC;

public class Directions {
    public static Direction of(Sort.Direction direction) {
        return direction.isAscending()
                ? ASC
                : DESC;
    }

    public static Sort.Direction of(Direction direction) {
        return ASC.equals(direction)
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;
    }
}
