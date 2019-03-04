package com.palmatolay.collections

@Suppress("UNCHECKED_CAST")
open class LinkedList<Type> {

    protected open var head: Node? = null
    var size: Int = 0
        //read-only from outside (but children can modify it)
        protected set

    @Suppress("PropertyName")
    protected val NOT_FOUND = "Data not found!"

    fun append(value: Type) {
        if (head == null) head = Node(data = value)
        //else getNode(isLastNeeded = true).next = Node(data = value)
        size++
    }

    open fun prepend(value: Type) { head = Node(value, head); size++ }

    operator fun get(key: Type): Type = getNode(key).data as Type ?: throw RuntimeException(NOT_FOUND)

    private fun getNode(key: Type, isLastNeeded: Boolean = false): Node {
        var current = head
        while (if (!isLastNeeded && key != null) getNodeDataStatement(current, key)
                else getLastNodeStatement(current)) {
            current = current?.next
        }
        return current ?: throw RuntimeException(NOT_FOUND)
    }

    private fun getNodeDataStatement(current: Node?, key: Type) = current!!.data as Type != key

    private fun getLastNodeStatement(current: Node?) = current?.next != null

    operator fun set(oldValue: Type, newValue: Type) {
        val tmp = getNode(oldValue)//.data = newValue
        tmp.data = newValue
    }
}