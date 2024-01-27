package com.alexandervbarkov.cleanarchitecture.commoncore.pagination;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

import static java.util.Collections.emptyList;

@Value
@Builder
@Jacksonized
public class Pageable {
    @Builder.Default
    int pageNumber = 0;
    @Builder.Default
    int pageSize = 50;
    @Builder.Default
    List<Sort> sort = emptyList();
}
