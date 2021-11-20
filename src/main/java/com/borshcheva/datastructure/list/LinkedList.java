package com.borshcheva.datastructure.list;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void add(T value) {
        Node<T> newNode = new Node<T>(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    @Override
    public void add(T value, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> newNode = new Node<T>(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

        } else if (index == 0) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            int count = 0;
            Node<T> current = head;
            while (count != index) {
                current = current.next;
                count++;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;

        }
        size++;
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> removedItem = null;

        if (index == 0) {
            Node<T> current = head;
            removedItem = head;
            head = current.next;
            current.next.prev = null;

        } else if (index == size - 1) {
            Node current = tail;
            removedItem = tail;
            tail = current.prev;
            current.prev.next = null;

        } else if (size == 1) {
            head = tail = null;

        } else {
            int count = 0;
            Node<T> current = head;
            while (count != index) {
                current = current.next;
                count++;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            removedItem = current;

        }

        size--;

        return removedItem.value;
    }

    @Override
    public T get(int index) {
        Node<T> current = head;
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return head.value;
        }
        if (index == size - 1) {
            return tail.value;
        }
        int count = 0;

        while (count != index) {
            current = current.next;
            count++;
        }
        return current.value;
    }

    @Override
    public T set(T value, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = getNode(index);
        current.value = value;
        return current.value;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(T value) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(value, current.value)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        Node<T> current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(value, current.value)) {
                return i;
            }
            current = current.prev;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        Node<T> current = head;
        int count = 0;
        while (count != size) {
            stringJoiner.add(current.value.toString());
            current = current.next;
            count++;
        }
        return stringJoiner.toString();
    }

    public Node<T> getNode(int index) {
        Node<T> node = head;

        int count = 0;

        while (count != index) {
            node = node.next;
            count++;
        }
        return node;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
    }


    private class MyIterator implements Iterator<T> {
        private int count;

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public T next() {
            return get(count++);
        }

        @Override
        public void remove() {
            int indexToRemove = count - 1;
            LinkedList.this.remove(indexToRemove);
        }
    }

}
