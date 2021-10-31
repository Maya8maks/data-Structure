package com.borshcheva.datastructure.queue;

public interface Queue {
    void enqueue(Object value);

    Object dequeue();

    Object peek();

    boolean contains(Object value);

    int size();

    boolean isEmpty();

    void clear();

    String toString();
}
