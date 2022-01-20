package queue

import linkedList.LinkedList

class LinkedListQueue<T> : Queue<T> {

    private val list = LinkedList<T>()

    override val count: Int
        get() = list.size

    override fun peek(): T? {
        return list.head?.value
    }

    override fun enqueue(element: T): Boolean {
        list.append(element)
        return true
    }

    override fun dequeue(): T? {
        return list.pop()
    }
}