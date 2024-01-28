package com.alexandervbarkov.cleanarchitecture.commoncore.pagination;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
    @Min(0)
    int pageNumber = 0;
    @Builder.Default
    @Max(200)
    int pageSize = 50;
    @Builder.Default
    List<Sort> sort = emptyList();
}
