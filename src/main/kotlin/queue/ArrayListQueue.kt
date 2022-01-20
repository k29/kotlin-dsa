package queue

class ArrayListQueue<T> : Queue<T> {
    private val list = arrayListOf<T>()

    override val count: Int
        get() = list.size

    override fun peek(): T? = list.getOrNull(0)

    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }

    override fun dequeue(): T? = if (list.isEmpty()) null else list.removeAt(0)
}
