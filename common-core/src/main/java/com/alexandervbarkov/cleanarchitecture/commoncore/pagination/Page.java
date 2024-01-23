package com.alexandervbarkov.cleanarchitecture.commoncore.pagination;

import java.util.List;

public interface Page<T> {
    List<T> getContent();

    Pageable getPageable();

    long getTotalElements();

    int getTotalElementsOnPage();

    int getTotalPages();
}
