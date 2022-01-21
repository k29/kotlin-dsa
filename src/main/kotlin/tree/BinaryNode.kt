package tree

class BinaryNode<T>(val value: T) {
    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    /**
     * In order traversal
     */
    fun inOrder(visit: (T) -> Unit) {
        leftChild?.inOrder(visit)
        visit(value)
        rightChild?.inOrder(visit)
    }

    /**
     * Post order traversal
     */
    fun postOrder(visit: (T) -> Unit) {
        leftChild?.postOrder(visit)
        rightChild?.postOrder(visit)
        visit(value)
    }

    /**
     * Pre Order traversal
     */
    fun preOrder(visit: (T) -> Unit) {
        visit(value)
        leftChild?.preOrder(visit)
        rightChild?.preOrder(visit)
    }

}