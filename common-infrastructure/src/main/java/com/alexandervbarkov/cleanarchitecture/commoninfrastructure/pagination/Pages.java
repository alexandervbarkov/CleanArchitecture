package com.alexandervbarkov.cleanarchitecture.commoninfrastructure.pagination;

import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Pageable;

import java.util.List;
import java.util.function.Function;

public class Pages {
    public static <Entity, Dto> Page<Dto> of(org.springframework.data.domain.Page<Entity> page, Pageable pageable, Function<Entity, Dto> entityToDtoMapper) {
        return new Page<>() {
            @Override
            public List<Dto> getContent() {
                return page.getContent()
                        .stream()
                        .map(entityToDtoMapper)
                        .toList();
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
