package com.alexandervbarkov.cleanarchitecture.commoninfrastructure.pagination;

import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Pageable;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Sort;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class Pageables {
    public static Pageable of(org.springframework.data.domain.Pageable pageable) {
        return new Pageable() {
            @Override
            public int getPageNumber() {
                return pageable.getPageNumber();
            }

            @Override
            public int getPageSize() {
                return pageable.getPageSize();
            }

            @Override
            public List<? extends Sort> getSort() {
                return Sorts.of(pageable.getSort());
            }
        };
    }

    public static org.springframework.data.domain.Pageable of(Pageable pageable) {
        return PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sorts.of(pageable.getSort())
        );
    }
}
