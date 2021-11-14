package com.borshcheva.datastructure.list;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class ArrayList implements List{

    private int size;
    private Object[] array;

    public ArrayList(int capacity) {
        array = new Object[capacity];
    }

    public ArrayList() {
        this(10);
    }
    @Override
    public void add(Object value) {
        ensureCapacity();
        array[size] = value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        if(index > size){
            throw new IndexOutOfBoundsException("Index is larger than size of the Array List");
        }
        ensureCapacity();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public Object remove(int index) {
        if(index > size){
            throw new IndexOutOfBoundsException("Index is larger than size of the Array List");
        }

        var indexArrayValue = array[index];

        System.arraycopy(array, index + 1, array, index, size - index);
        array[size-1] = null;
        size--;
        return indexArrayValue;
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        var result = array[index];
        array[index] = value;
        return result;
    }

    @Override
    public void clear() {
        for (int i=0; i < size; i++) {
            array[i] = null;
        }
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
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            Object valueInStack = array[i];
            if (Objects.equals(value, valueInStack)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            Object valueInStack = array[i];
            if (Objects.equals(value, valueInStack)) {
                return i;
            }
        }
        return -1;
    }

    private void ensureCapacity(){
        if (size == array.length) {
            Object[] newArray = new Object[(int) (array.length * 1.5)];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ","[","]");
        for (int i = 0; i < size; i++) {
            stringJoiner.add(array[i].toString());
        }
        return stringJoiner.toString();
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator{
        private int count;

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public Object next() {

            return get(count++);
        }

        @Override
        public void remove() {
            int indexToRemove = count - 1;
            ArrayList.this.remove(indexToRemove);
        }
    }
}
