package com.alexandervbarkov.cleanarchitecture.commoncore.pagination;

import java.util.List;

public interface Pageable {
    int getPageNumber();

    int getPageSize();

    List<? extends Sort> getSort();
}
