package LinkedList

/**
 * Linked List
 */
class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        if (isEmpty()) {
            return "Empty list"
        } else {
            return head.toString()
        }
    }

    /**
     * Push in front of the LL.
     * Note the use of builder pattern or fluent interface pattern here.
     * With this you can:
     * val list = LinkedList<Int>()
     * list.push(2).push(3).push(4)
     */
    fun push(value: T): LinkedList<T> {
        head = Node(value, head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    /**
     * Append at the end of the LL
     */
    fun append(value: T): LinkedList<T> {
        if (isEmpty()) {
            push(value)
            return this
        }
        tail?.next = Node(value)
        tail = tail?.next
        size++
        return this
    }

    /**
     * Return node at a given index
     */
    fun nodeAt(index: Int) : Node<T>? {
        var itrNode = head
        var itrIndex = 0

        while (itrNode != null && itrIndex < index) {
            itrNode = itrNode.next
            itrIndex++
        }
        return itrNode
    }

    /**
     * Insert after node
     */
    fun insert(value: T, afterNode: Node<T>) : Node<T> {
        if (tail == afterNode) {
            append(value)
            return tail!! // throw an exception if tail is null
        }

        val temp = Node(value, afterNode.next)
        afterNode.next = temp
        size++
        return temp
    }

    /**
     * Pop from front of the list
     */
    fun pop(): T? {
        if (!isEmpty()) size --
        val result = head?.value
        head = head?.next

        // if after popping list is empty:
        if (isEmpty()) tail = null

        return result
    }
}