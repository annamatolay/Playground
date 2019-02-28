package com.palmatolay.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@SuppressWarnings("unchecked")
public class ArrayListTest {

    private ArrayList list;
    private final Integer DEFAULT_VALUE = 0;
    private final List<Integer> EXPECTED_LIST = Arrays.asList(3, 6, 9);

    private void addExpectedIntegers(boolean createNewList) {
        if (createNewList) list = new ArrayList<Integer>();
        for (int i : EXPECTED_LIST)
            list.add(i);
    }

    private void assertListWithTestArray(int[] expectedList) {
        for (int i = DEFAULT_VALUE; i < list.size(); i++)
            assertEquals(expectedList[i], list.get(i));
    }

    @Before
    public void setUp() {
        list = new ArrayList<Integer>();
        list.add(DEFAULT_VALUE);
    }

    @Test
    public void checkInstance() { assertNotNull(list); }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void clear() { list.clear(); assertEquals(0, list.size()); list.get(DEFAULT_VALUE); }

    @Test
    public void getSize() { assertEquals(1, list.size()); }

    @Test
    public void getDefaultElement() { assertEquals(DEFAULT_VALUE, list.get(DEFAULT_VALUE)); }

    @Test
    public void getSize_afterAddIntegers() {
        addExpectedIntegers(false);
        assertEquals(4, list.size());
    }

    @Test
    public void getAllElements_afterAddIntegers() {
        addExpectedIntegers(true);
        for (int i = DEFAULT_VALUE; i < list.size(); i++)
            assertEquals(EXPECTED_LIST.get(i), list.get(i));
    }

    @Test
    public void setAndGetNewInteger_atGivenIndex() {
        int EXPECTED_VALUE = 1;
        list.set(EXPECTED_VALUE, DEFAULT_VALUE);
        assertEquals(EXPECTED_VALUE, list.get(DEFAULT_VALUE));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeWhenListIsEmpty() { list.clear(); list.remove(DEFAULT_VALUE); }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeDefaultElement() { list.remove(DEFAULT_VALUE); list.get(DEFAULT_VALUE); }

    @Test
    public void removeMiddleElement_whenArraySizeThree() {
        addExpectedIntegers(true);
        list.remove(1);
        assertEquals(2, list.size());
        int[] expectedList = new int[] {3, 9};
        assertListWithTestArray(expectedList);
    }

    @Test
    public void removeThirdElement_whenArraySizeFour() {
        addExpectedIntegers(false);
        list.remove(2);
        assertEquals(3, list.size());
        int[] expectedList = new int[] {0, 3, 9};
        assertListWithTestArray(expectedList);
    }
}
