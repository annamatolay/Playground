package com.palmatolay.collections

import jdk.nashorn.internal.ir.annotations.Ignore
import org.junit.Test
import org.junit.Assert.*

class LinkedListTest {

    companion object {
        const val DEFAULT_INT = 0
        val DEFAULT_STRING = "DEFAULT"
        val DEFAULT_LIST = listOf(3, 6, 9)
    }

    private val list = LinkedList<Int>()

//    @Before
//    fun setUp()

    @Test
    fun checkInstanceNotNull() = assertNotNull(list)

    @Test
    fun appendDefaultInt_checkSizeIncreased() {
        assertEquals(DEFAULT_INT, list.size)
        list.append(DEFAULT_INT)
        assertEquals(1, list.size)
    }

    @Test
    fun prependDefaultInt_checkSizeIncreased() {
        assertEquals(DEFAULT_INT, list.size)
        list.prepend(DEFAULT_INT)
        assertEquals(1, list.size)
    }

    @Test
    fun getNode() {
        list.append(DEFAULT_INT)
        assertEquals(DEFAULT_INT, list[DEFAULT_INT])
    }

    @Test
    fun updateDefaultElement() {
        list.append(DEFAULT_INT)
        list[DEFAULT_INT] = 1
        assertEquals(1, list[DEFAULT_INT])
    }
}