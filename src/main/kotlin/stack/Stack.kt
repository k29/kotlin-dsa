package stack

interface Stack<T> {
    val count: Int

    val isEmpty: Boolean
        get() = count == 0

    fun push(element: T): Boolean

    fun pop(): T?
}