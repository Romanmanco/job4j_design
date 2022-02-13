package ru.job4j.collection.list;

import ru.job4j.collection.list.linked.ForwardLinked;

public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<T>();
    public int size;

    public T pop() {
        return linked.deleteFirst();
    }

    public void push(T value) {
        linked.addFirst(value);
    }

    public int size() {
        return size();
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
