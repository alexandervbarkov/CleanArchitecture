package com.alexandervbarkov.cleanarchitecture.commoncore.pagination;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@Builder
@Jacksonized
public class Page<T> {
    List<T> content;
    Pageable pageable;
    long totalElements;
    int totalElementsOnPage;
    int totalPages;
}
