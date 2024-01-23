package com.alexandervbarkov.cleanarchitecture.commoncore.pagination;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
public class PageDto<T> implements Page<T> {
    private final List<T> content;
    private final PageableDto pageable;
    private final long totalElements;
    private final int totalElementsOnPage;
    private final int totalPages;
}
