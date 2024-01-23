package com.alexandervbarkov.cleanarchitecture.common.core.pagination;

public interface Sort {
    String getProperty();

    Direction getDirection();
}
