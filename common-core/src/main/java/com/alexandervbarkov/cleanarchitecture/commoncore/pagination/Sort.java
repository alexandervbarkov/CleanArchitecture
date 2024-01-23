package com.alexandervbarkov.cleanarchitecture.commoncore.pagination;

public interface Sort {
    String getProperty();

    Direction getDirection();
}
