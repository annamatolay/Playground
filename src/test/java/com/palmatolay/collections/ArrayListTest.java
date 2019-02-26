package com.palmatolay.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ArrayListTest {

    private ArrayList list;

    @Before
    public void setUp() { list = new ArrayList<Integer>(); }

    @Test
    public void checkInstance() { assertNotNull(list); }

    @Test
    public void getSize() { assertEquals(0, list.size()); }

    @Test
    public void getSize_afterAddNumber() {
        list.add(0);
        assertEquals(1, list.size());
    }

    @Test
    public void addAndGetFirstElement() {
        list.add(3);
        assertEquals(3, list.get(0));
    }

    @Test
    public void addAndGetMoreElements() {
        int[] expected = {3, 6, 9};
        for (int i : expected)
            list.add(i);
        assertEquals(3, list.size());
        for (int i = 0; i < list.size(); i++)
            assertEquals(expected[i], list.get(i));
    }
}
