package com.palmatolay.collections

class HashMap<KeyType, ValueType> {
    private var head: Entry<KeyType, ValueType>? = null

    data class Entry<KeyType, ValueType>(
            val key: KeyType,
            var value: ValueType,
            var prev: KeyType? = null,
            var next: Entry<KeyType, ValueType>? = null)

    internal operator fun set(key: KeyType, value: ValueType) {
        if (head == null) prepend(key, value)
        else {
            val entry = getEntry(key)
            if (entry != null) entry.value = value
            else prepend(key, value)
        }
    }

    private fun prepend(key: KeyType, value: ValueType) {
        head = Entry(key, value, next = head)
        head?.next?.prev = head?.key
    }

    @Suppress("UNCHECKED_CAST")
    internal operator fun get(key: KeyType): ValueType =
            getEntry(key)?.value as ValueType ?: throw RuntimeException("Data not found!")

    private fun getEntry(key: KeyType): Entry<KeyType, ValueType>? {
        if (head == null) throw RuntimeException("HashMap is empty!")
        var current = head
        while (current != null && current.key != key)
            current = current.next
        return current
    }

    fun put(key: KeyType, value: ValueType) = set(key, value)

    fun remove(key: KeyType): Boolean {
        val current = getEntry(key) ?: throw RuntimeException("Data not found!")
        val nextElement = current.next
        val prevElement = getEntry(current.prev ?: key)
        if (prevElement == current) head = nextElement
        else
            prevElement?.next = nextElement
            nextElement?.prev = prevElement?.key
        return true
    }
}