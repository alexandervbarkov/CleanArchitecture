package com.alexandervbarkov.cleanarchitecture.configuration.testutil


import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Page
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Pageable

class PageUtils {
    private static final DEFAULT_PAGEABLE = Pageable.builder().build()

    static <T> Page<T> buildExpectedPage(
            int totalElements = 1,
            int totalElementsOnPage = 1,
            int totalPages = 1,
            Pageable pageable = DEFAULT_PAGEABLE,
            T... elements
    ) {
        Page<T>.builder()
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
