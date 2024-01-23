package com.alexandervbarkov.cleanarchitecture.common.core.pagination;

import java.util.List;

public interface Pageable {
    int getPageNumber();

    int getPageSize();

    List<? extends Sort> getSort();
}
