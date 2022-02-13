package ru.job4j.collection.list.linked;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void addFirst(T value) {
        head = new Node<>(value, head);
    }

    public T deleteFirst() {
        Node<T> node = head;
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
        node.next = node;
        return node.value;
    }

    public boolean revert() {
        ForwardLinked<T> newList = new ForwardLinked<>();
        if (head == null || head.next == null) {
            return false;
        }
        while (head != null) {
            newList.addFirst(this.deleteFirst());
        }
        head = newList.head;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}