package com.borshcheva.datastructure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    public void testAdd() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        assertEquals(2, arrayList.size());
        assertEquals("A", arrayList.get(0));
        assertEquals("B", arrayList.get(1));
    }

    @Test
    public void testAddWithValueAndIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C", 0);

        assertEquals(3, arrayList.size());
        assertEquals("C", arrayList.get(0));
        assertEquals("A", arrayList.get(1));
        assertEquals("B", arrayList.get(2));
    }

    @Test
    public void testRemove() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        arrayList.remove(0);

        assertEquals(2, arrayList.size());
        assertEquals("B", arrayList.get(0));
        assertEquals("C", arrayList.get(1));
    }

    @Test
    public void testGetListElement() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals("B", arrayList.get(1));
        assertEquals("C", arrayList.get(2));
    }

    @Test
    public void testSetListElement() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        arrayList.set("G", 0);

        assertEquals("G", arrayList.get(0));

    }

    @Test
    public void testClearList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        arrayList.clear();
        assertEquals(0, arrayList.size());
        assertEquals(null, arrayList.get(0));

    }

    @Test
    public void testContainsReturnTrue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertTrue(arrayList.contains(new String("A")));
    }

    @Test
    public void testContainsReturnFalse() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        assertFalse(arrayList.contains("C"));
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
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("C", 4);
        });
    }

    @Test
    public void testContainsReturnFalseOnEmptyList() {
        ArrayList arrayList = new ArrayList();

        assertFalse(arrayList.contains("C"));
    }

    @Test
    public void testIndexOfSuccess() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");

        assertEquals(0, arrayList.indexOf("A"));

    }

    @Test
    public void testIndexOfFalse() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");

        assertEquals(-1, arrayList.indexOf("C"));

    }

    @Test
    public void testLastIndexOfSuccess() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");

        assertEquals(2, arrayList.lastIndexOf("A"));

    }

    @Test
    public void testLastIndexOfFalse() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");

        assertEquals(-1, arrayList.lastIndexOf("C"));

    }
}
