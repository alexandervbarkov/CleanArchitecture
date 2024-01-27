package com.alexandervbarkov.cleanarchitecture.commoninfrastructure.pagination;

import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Pageable;

import java.util.List;
import java.util.function.Function;

public class Pages {
    public static <Entity, Dto> Page<Dto> of(
            org.springframework.data.domain.Page<Entity> page,
            Pageable pageable,
            Function<Entity, Dto> entityToDtoMapper
    ) {
        return Page.<Dto>builder()
                .content(getContent(page, entityToDtoMapper))
                .pageable(pageable)
                .totalElements(page.getTotalElements())
                .totalElementsOnPage(page.getNumberOfElements())
                .totalPages(page.getTotalPages())
                .build();
    }

    private static <Entity, Dto> List<Dto> getContent(
            org.springframework.data.domain.Page<Entity> page,
            Function<Entity, Dto> entityToDtoMapper
    ) {
        return page.getContent()
                .stream()
                .map(entityToDtoMapper)
                .toList();
    }
}
