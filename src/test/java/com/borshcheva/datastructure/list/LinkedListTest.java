package com.borshcheva.datastructure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {

    @Test
    public void testAdd() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");

        assertEquals(2, linkedList.size());
        assertEquals("A", linkedList.get(0));
        assertEquals("B", linkedList.get(1));
    }

    @Test
    public void testAddWithValueAndFirstIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C", 0);

        assertEquals(3, linkedList.size());
        assertEquals("C", linkedList.get(0));
        assertEquals("A", linkedList.get(1));
        assertEquals("B", linkedList.get(2));
    }

    @Test
    public void testAddWithValueAndIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C", 1);

        assertEquals(3, linkedList.size());
        assertEquals("A", linkedList.get(0));
        assertEquals("C", linkedList.get(1));
        assertEquals("B", linkedList.get(2));
    }

    @Test
    public void testAddWithValueAndLastIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C", 2);

        assertEquals(3, linkedList.size());
        assertEquals("A", linkedList.get(0));
        assertEquals("B", linkedList.get(1));
        assertEquals("C", linkedList.get(2));
    }

    @Test
    public void testRemoveFirstElement() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        linkedList.remove(0);

        assertEquals(2, linkedList.size());
        assertEquals("B", linkedList.get(0));
        assertEquals("C", linkedList.get(1));
    }

    @Test
    public void testRemoveLastElement() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        linkedList.remove(2);

        assertEquals(2, linkedList.size());
        assertEquals("A", linkedList.get(0));
        assertEquals("B", linkedList.get(1));
    }

    @Test
    public void testRemoveElement() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        linkedList.remove(1);

        assertEquals(2, linkedList.size());
        assertEquals("A", linkedList.get(0));
        assertEquals("C", linkedList.get(1));
    }

    @Test
    public void testGetListElement() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        assertEquals("B", linkedList.get(1));
        assertEquals("C", linkedList.get(2));
    }

    @Test
    public void testSetListElement() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        linkedList.set("G", 2);

        assertEquals("A", linkedList.get(0));
        assertEquals("B", linkedList.get(1));
        assertEquals("G", linkedList.get(2));

    }

    @Test
    public void testClearList() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        linkedList.clear();
        assertEquals(0, linkedList.size());

    }

    @Test
    public void testContainsReturnTrue() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        assertTrue(linkedList.contains(new String("A")));
    }

    @Test
    public void testContainsReturnFalse() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");

        assertFalse(linkedList.contains("C"));
    }

    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenRemoveOnLargerIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(4);
        });
    }

    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenAddLargerIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.add("C", 4);
        });
    }

    @Test
    public void testContainsReturnFalseOnEmptyList() {
        LinkedList linkedList = new LinkedList();

        assertFalse(linkedList.contains("C"));
    }

    @Test
    public void testIndexOfSuccess() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");

        assertEquals(0, linkedList.indexOf("A"));

    }

    @Test
    public void testIndexOfFalse() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");

        assertEquals(-1, linkedList.indexOf("C"));

    }

    @Test
    public void testLastIndexOfSuccess() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("A");

        assertEquals(2, linkedList.lastIndexOf("A"));

    }

    @Test
    public void testLastIndexOfFalse() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("A");

        assertEquals(-1, linkedList.lastIndexOf("C"));

    }
}
