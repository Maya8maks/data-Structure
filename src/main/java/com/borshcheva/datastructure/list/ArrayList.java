package com.borshcheva.datastructure.list;

import java.util.Objects;

public class ArrayList implements List{

    private int size;
    private Object[] array;

    public ArrayList() {
        array = new Object[10];
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
        if (value == null) {
            throw new NullPointerException("Nulls are not supported");
        }
        ensureCapacity();
      var indexArrayValue = array[index];
        for (int i = size-1; i >= index; i--) {
            array[i+1] = array[i];
        }
        array[index] = value;
        size++;
    }

    @Override
    public Object remove(int index) {
        if(index > size){
            throw new IndexOutOfBoundsException("Index is larger than size of the Array List");
        }

        var indexArrayValue = array[index];

        for (int i = index; i < size; i++) {
            array[i] = array[i+1];
        }
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
        for (int i = 0; i < size; i++) {
            Object valueInStack = array[i];
            if (Objects.equals(valueInStack, value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            Object valueInStack = array[i];
            if (value.equals(valueInStack)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            Object valueInStack = array[i];
            if (value.equals(valueInStack)) {
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
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(array[i].toString());
            if(i==size-1){
                break;
            }
            else {
                result.append(", ");
            }
        }
        return  "[" + result + "]";
    }
}
