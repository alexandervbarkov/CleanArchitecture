package com.alexandervbarkov.cleanarchitecture.commoncore.chainofresponsibility;

public abstract class ChainFacade<I, O> {
    protected final Chain<I, O> first;

    @SafeVarargs
    protected ChainFacade(Chain<I, O>... chain) {
        if (chain == null || chain.length < 2) {
            throw new IllegalStateException("Chain should have at least two elements");
        }
        for (int i = 0; i < chain.length - 1; i++) {
            chain[i].setNext(chain[i + 1]);
        }
        first = chain[0];
    }
}
