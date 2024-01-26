package com.alexandervbarkov.cleanarchitecture.commoncore.chainofresponsibility;

import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public class LastInChain<I, O> implements Chain<I, O> {
    private final Function<I, O> action;

    @Override
    public O action(I input) {
        return action.apply(input);
    }

    @Override
    public void setNext(Chain<I, O> next) {

    }
}
