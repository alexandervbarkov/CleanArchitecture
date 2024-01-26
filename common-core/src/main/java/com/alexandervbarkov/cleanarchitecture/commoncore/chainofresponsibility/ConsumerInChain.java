package com.alexandervbarkov.cleanarchitecture.commoncore.chainofresponsibility;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.function.Consumer;

@RequiredArgsConstructor
public class ConsumerInChain<I, O> implements Chain<I, O> {
    private final Consumer<I> action;
    @Setter
    private Chain<I, O> next;

    @Override
    public O action(I input) {
        action.accept(input);
        return next.action(input);
    }
}
