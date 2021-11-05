package com.borshcheva.datastructure.list;

public class LinkedList implements List{

    private Node head;
    private Node tail;
    private int size;

    @Override
    public void add(Object value) {
        Node newNode = new Node(value);
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
    public void add(Object value, int index) {
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else if(index == size){
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

        } else if(index == 0) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            int count = 0;
            Node current = head;
            while(count != index) {
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
    public Object remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node removedItem = null;

        if (index == 0) {
            Node current = head;
            removedItem = head;
            head = current.next;
            current.next.prev = null;

        } else if (index == size-1) {
            Node current = tail;
            removedItem = tail;
            tail = current.prev;
            current.prev.next = null;

        } else {
            int count = 0;
            Node current = head;
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
    public Object get(int index) {
        Node current = head;
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return head.value;
        }
        if(index == size -1){
            return tail.value;
        }
        int count = 0;

        while(count != index) {
            current = current.next;
            count++;
        }
        return current.value;
    }

    @Override
    public Object set(Object value, int index) {
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        Node current = head;
        while(counter != index) {
            current = current.next;
            counter++;
        }
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
    public boolean contains(Object value) {
        Node current = head;
        for (int i = 0; i < size; i++) {

            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        Node current = head;
        for (int i = 0; i < size; i++) {

            if (current.value.equals(value)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node current = head;
        for (int i = size - 1; i >= 0; i--) {

            if (current.value.equals(value)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }
}
