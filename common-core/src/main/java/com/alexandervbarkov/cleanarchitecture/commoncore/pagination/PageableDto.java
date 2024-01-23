package com.alexandervbarkov.cleanarchitecture.commoncore.pagination;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static java.util.Collections.emptyList;

@Data
@Builder
@RequiredArgsConstructor
public class PageableDto implements Pageable {
    private final int pageNumber = 0;
    private final int pageSize = 50;
    private final List<SortDto> sort = emptyList();
}
