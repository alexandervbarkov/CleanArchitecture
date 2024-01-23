package com.alexandervbarkov.cleanarchitecture.testutil

import com.alexandervbarkov.cleanarchitecture.common.core.pagination.Page
import com.alexandervbarkov.cleanarchitecture.common.core.pagination.PageDto
import com.alexandervbarkov.cleanarchitecture.common.core.pagination.PageableDto

class PageUtils {
    private static final DEFAULT_PAGEABLE = new PageableDto()

    static <T> Page<T> buildExpectedPage(
            int totalElements = 1,
            int totalElementsOnPage = 1,
            int totalPages = 1,
            PageableDto pageable = DEFAULT_PAGEABLE,
            T... elements
    ) {
        PageDto<T>.builder()
                .content(elements as List)
                .pageable(pageable)
                .totalElements(totalElements)
                .totalElementsOnPage(totalElementsOnPage)
                .totalPages(totalPages)
                .build()
    }

    static Page<?> buildEmptyPage() {
        buildExpectedPage(0, 0, 0)
    }
}
