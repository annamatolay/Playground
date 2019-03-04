package com.palmatolay.collections

class Stack<Type>(capacity: Int = 0): LinkedList<Type>(){

    fun push(value: Type) = prepend(value)

    @Suppress("UNCHECKED_CAST")
    fun pop(): Type? = if (head != null) head?.data as Type else null
}