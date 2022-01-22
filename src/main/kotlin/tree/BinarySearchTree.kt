package tree

/**
 * Binary search tree can only hold values which
 * implement the comparable interface.
 */
class BinarySearchTree<T: Comparable<T>> {
    /**
     * Root node
     */
    var root: BinaryNode<T>? = null

    /**
     * Insert helper function
     */
    private fun insert(node: BinaryNode<T>?, value: T): BinaryNode<T> {
        // In case root is null, return the value wrapped in BinaryNode
        node ?: return(BinaryNode(value))

        if(value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }

        // this makes "val node = insert(value)" possible
        return node
    }

    /**
     * Insert into BST
     */
    fun insert(value: T) {
        root = insert(root, value)
    }

    /**
     * Return true/false in case element is present in the tree.
     * Runs in log(n).
     * You can use the inorder scan to do it in O(n) as well.
     */
    fun contains(value: T) : Boolean {
        // if root is null, return false
        root?: return false

        var temp = root
        while(temp != null) {
            if(temp.value == value) {
                return true
            } else if (value < temp.value ){
                temp = temp.leftChild
            } else if (value > temp.value) { // this is just explicit, not required.
                temp = temp.rightChild
            }
        }
        return false
    }

    /**
     * Find min. value from a given node and below and return that node.
     */
    fun findMin(node: BinaryNode<T>?) : BinaryNode<T>? {
        // if node is null, return null
        node?: return null

        if(node.leftChild == null)
            return node

        return findMin(node.leftChild)
    }

    /**
     * Helper function to remove a given node
     */
    private fun remove(node: BinaryNode<T>?, value: T): BinaryNode<T>? {
        // if root is null, nothing to remove, return null
        node ?: return null

        when {
            // when you catch the value
            value == node.value -> {
                // leaf node, return null to delete the left child
                if (node.leftChild == null && node.rightChild == null)
                    return null

                // single child
                if (node.leftChild == null)
                    return node.rightChild

                if(node.rightChild == null)
                    return node.leftChild

                // two children
                node.value = findMin(node.rightChild)?.value!! // reassign the value to the min. value in right subtree
                node.rightChild = remove(node.rightChild, node.value) // remove the new value from right subtree
            }

            value < node.value -> node.leftChild = remove(node.leftChild, value)

            value > node.value -> node.rightChild = remove(node.rightChild, value)
        }
        return node
    }

    /**
     * Remove a node with the given value from the BST
     */
    fun remove(value: T) {
        root = remove(root, value)
    }
}

