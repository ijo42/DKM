package ru.ijo42.dkm.interfaces;

@FunctionalInterface
public interface TripleConsumer<T, Y, U> {

    void accept(T t, Y y, U u);

}
