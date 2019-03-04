package com.palmatolay.collections

import com.palmatolay.collections.TestData.Companion.DEFAULT_INT
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class StackTest {
    private lateinit var stack: Stack<Int>

    @Before
    fun setUp() { stack = Stack(capacity = 3) }

    @Test
    fun checkInstance() = assertNotNull(setUp())

    @Test
    fun pushDefaultInt()  = assertNull(stack.push(DEFAULT_INT))

    @Test
    fun validateSizeAfterPush() {
        pushDefaultInt()
        assertEquals(1, stack.size)
    }

    @Test
    fun popFromEmptyStack() = assertNull(stack.pop())

    @Test
    fun popElementAfterPush() {
        pushDefaultInt()
        assertEquals(DEFAULT_INT, stack.pop())
    }
}