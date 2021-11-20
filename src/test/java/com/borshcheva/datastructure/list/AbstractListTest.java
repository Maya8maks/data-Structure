package com.borshcheva.datastructure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractListTest {
    private List list;

    @BeforeEach
    public void before() {
        list = getList();
    }

    protected abstract List getList();

    @Test
    public void testAdd() {

        list.add("A");
        list.add("B");

        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    public void testAddWithValueAndFirstIndex() {

        list.add("A");
        list.add("B");
        list.add("C", 0);

        assertEquals(3, list.size());
        assertEquals("C", list.get(0));
        assertEquals("A", list.get(1));
        assertEquals("B", list.get(2));
    }

    @Test
    public void testAddWithValueAndIndex() {

        list.add("A");
        list.add("B");
        list.add("C", 1);

        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
        assertEquals("B", list.get(2));
    }

    @Test
    public void testAddWithValueAndLastIndex() {

        list.add("A");
        list.add("B");
        list.add("C", 2);

        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    public void testRemoveFirstElement() {

        list.add("A");
        list.add("B");
        list.add("C");

        list.remove(0);

        assertEquals(2, list.size());
        assertEquals("B", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    public void testRemoveLastElement() {

        list.add("A");
        list.add("B");
        list.add("C");

        list.remove(2);

        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    public void testRemoveElement() {

        list.add("A");
        list.add("B");
        list.add("C");

        list.remove(1);

        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    public void testGetListElement() {

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    public void testSetListElement() {

        list.add("A");
        list.add("B");
        list.add("C");

        list.set("G", 2);

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("G", list.get(2));

    }

    @Test
    public void testClearList() {

        list.add("A");
        list.add("B");
        list.add("C");

        list.clear();
        assertEquals(0, list.size());

    }

    @Test
    public void testContainsReturnTrue() {

        list.add("A");
        list.add("B");
        list.add("C");

        assertTrue(list.contains(new String("A")));
    }

    @Test
    public void testContainsReturnFalse() {

        list.add("A");
        list.add("B");

        assertFalse(list.contains("C"));
    }

    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenRemoveOnLargerIndex() {

        list.add("A");
        list.add("B");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(4);
        });
    }

    @Test
    public void testThrowIndexOutOfBoundsExceptionWhenAddLargerIndex() {

        list.add("A");
        list.add("B");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add("C", 4);
        });
    }

    @Test
    public void testContainsReturnFalseOnEmptyList() {
        assertFalse(list.contains("C"));
    }

    @Test
    public void testIndexOfSuccess() {

        list.add("A");

        assertEquals(0, list.indexOf("A"));

    }

    @Test
    public void testIndexOfFalse() {

        list.add("A");

        assertEquals(-1, list.indexOf("C"));

    }

    @Test
    public void testLastIndexOfSuccess() {
        list.add("A");
        list.add("B");
        list.add("A");

        assertEquals(2, list.lastIndexOf("A"));
        assertEquals(1, list.lastIndexOf("B"));

    }

    @Test
    public void testLastIndexOfFalse() {

        list.add("A");
        list.add("B");
        list.add("A");

        assertEquals(-1, list.lastIndexOf("C"));

    }
}
