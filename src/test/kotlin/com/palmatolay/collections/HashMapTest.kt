package com.palmatolay.collections

import org.junit.Assert.*
import org.junit.Test
import kotlin.RuntimeException


class HashMapTest {

    companion object {
        private const val DEFAULT_INT = 0
        private const val DEFAULT_STRING = "DEFAULT"
        private const val DEFAULT_STRING_INT = "369"
    }

    private var map = HashMap<String, Int>()

    private fun setDefault() { map[DEFAULT_STRING] = DEFAULT_INT }

    private fun populateMapWithThreeEntry() = DEFAULT_STRING_INT.forEach { map.put("$it", it.toInt()) }

    @Test
    fun checkInstance() = assertNotNull(map)

    @Test
    fun setAndGetDefaultElement() {
        setDefault()
        assertEquals(DEFAULT_INT, map[DEFAULT_STRING])
    }

    @Test
    fun putMoreElementsAndGetBackLast() {
        setDefault()
        map.put(DEFAULT_STRING_INT, DEFAULT_STRING_INT.toInt())
        assertEquals(369, map[DEFAULT_STRING_INT])
    }

    @Test
    fun updateElement() {
        setAndGetDefaultElement()
        map[DEFAULT_STRING] = DEFAULT_STRING_INT.toInt()
        assertEquals(369, map[DEFAULT_STRING])
    }

    @Test(expected = RuntimeException::class)
    fun removeDefault() {
        setAndGetDefaultElement()
        map.remove(DEFAULT_STRING)
        assertNotNull(DEFAULT_STRING)
    }

    @Test(expected = RuntimeException::class)
    fun removeElement() {
        populateMapWithThreeEntry()
        val secondKey = "${DEFAULT_STRING_INT[1]}"
        assertTrue(map.remove(secondKey))
        assertNull(map[secondKey])
    }
}