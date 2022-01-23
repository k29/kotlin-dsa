package tree

/**
 * Perfectly balanced tree: every level is filled with nodes from top to bottom
 *
 * Balanced tree: every level is filled with nodes, except the bottom one
 *
 * Keeping the tree balanced gives insert, find and remove operation O(log(n)) complexity.
 *
 * AVL maintains this balance by adjusting the structure when it becomes unbalanced.
 *
 * BST and AVL share much of the implementation, except for the balancing component.
 */
class AVLNode<T: Comparable<T>>  {
    var leftChild: AVLNode<T>? = null
    var rightChild: AVLNode<T>? = null

    /**
     * Longest distance between current node and leaf node.
     * Relative heights of nodes children will be used to determine whether a node is balanced.
     * Height of left and right children should differ by 1. This is the balance factor.
     */
    var height = 0

    val leftHeight: Int
        get() = leftChild?.height ?: -1

    val rightHeight: Int
        get() = rightChild?.height ?: -1

    val balanceFactor: Int
        get() = leftHeight - rightHeight

}