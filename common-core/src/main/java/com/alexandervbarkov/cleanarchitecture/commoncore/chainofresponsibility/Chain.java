package com.alexandervbarkov.cleanarchitecture.commoncore.chainofresponsibility;

public interface Chain<I, O> {
    O action(I input);

    void setNext(Chain<I, O> next);
}
