package stack

class ArrayListStack<T> : Stack<T> {

    private val list = arrayListOf<T>()

    override val count: Int
        get() = list.size


    override fun push(element: T): Boolean {
        list.add(element)
        return true
    }

    override fun pop(): T? {
        if (isEmpty) return null

        return list.removeAt(count - 1)
    }
}