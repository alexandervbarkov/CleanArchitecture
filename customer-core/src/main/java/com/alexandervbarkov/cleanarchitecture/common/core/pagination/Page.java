package com.alexandervbarkov.cleanarchitecture.common.core.pagination;

import java.util.List;

public interface Page<T> {
    List<T> getContent();

    Pageable getPageable();

    long getTotalElements();

    int getTotalElementsOnPage();

    int getTotalPages();
}
