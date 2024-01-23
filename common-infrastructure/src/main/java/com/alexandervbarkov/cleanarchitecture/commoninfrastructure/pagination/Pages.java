package com.alexandervbarkov.cleanarchitecture.commoninfrastructure.pagination;

import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Pageable;

import java.util.List;

public class Pages {
    public static <T> Page<T> of(org.springframework.data.domain.Page<T> page, Pageable pageable) {
        return new Page<T>() {
            @Override
            public List<T> getContent() {
                return page.getContent();
            }

            @Override
            public Pageable getPageable() {
                return pageable;
            }

            @Override
            public long getTotalElements() {
                return page.getTotalElements();
            }

            @Override
            public int getTotalElementsOnPage() {
                return page.getNumberOfElements();
            }

            @Override
            public int getTotalPages() {
                return page.getTotalPages();
            }
        };
    }
}
