package com.alexandervbarkov.cleanarchitecture.commoninfrastructure.pagination;

import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Direction;
import com.alexandervbarkov.cleanarchitecture.commoncore.pagination.Sort;

import java.util.List;
import java.util.function.Function;

import static java.util.Collections.emptyList;
import static org.springframework.util.CollectionUtils.isEmpty;

public class Sorts {
    public static List<? extends Sort> of(org.springframework.data.domain.Sort sort) {
        return sort.isSorted()
                ? toSorts(sort)
                : emptyList();
    }

    private static List<Sort> toSorts(org.springframework.data.domain.Sort sort) {
        return sort.get()
                .map(toSort)
                .toList();
    }

    private static final Function<org.springframework.data.domain.Sort.Order, Sort> toSort =
            it -> new Sort() {
                @Override
                public String getProperty() {
                    return it.getProperty();
                }

                @Override
                public Direction getDirection() {
                    return Directions.of(it.getDirection());
                }
            };

    public static org.springframework.data.domain.Sort of(List<? extends Sort> sorts) {
        return isEmpty(sorts)
                ? org.springframework.data.domain.Sort.unsorted()
                : org.springframework.data.domain.Sort.by(toOrders(sorts));
    }

    private static List<org.springframework.data.domain.Sort.Order> toOrders(List<? extends Sort> sorts) {
        return sorts.stream()
                .map(toOrder)
                .toList();
    }

    private static final Function<Sort, org.springframework.data.domain.Sort.Order> toOrder =
            sort -> new org.springframework.data.domain.Sort.Order(
                    Directions.of(sort.getDirection()),
                    sort.getProperty()
            );
}
