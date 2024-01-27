package com.alexandervbarkov.cleanarchitecture.commoninfrastructure.pagination;

import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Pageable;
import org.springframework.data.domain.PageRequest;

public class Pageables {
    public static Pageable of(org.springframework.data.domain.Pageable pageable) {
        return Pageable.builder()
                .pageNumber(pageable.getPageNumber())
                .pageSize(pageable.getPageSize())
                .sort(Sorts.of(pageable.getSort()))
                .build();
    }

    public static org.springframework.data.domain.Pageable of(Pageable pageable) {
        return PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sorts.of(pageable.getSort())
        );
    }
}
