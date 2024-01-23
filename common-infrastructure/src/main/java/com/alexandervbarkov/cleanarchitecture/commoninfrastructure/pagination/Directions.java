package com.alexandervbarkov.cleanarchitecture.commoninfrastructure.pagination;

import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Direction;
import org.springframework.data.domain.Sort;

import static com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Direction.ASC;
import static com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Direction.DESC;

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
