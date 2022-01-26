package tree

import kotlin.math.max

class AVLTree<T: Comparable<T>> {
    /**
     * Root node
     */
    var root: AVLNode<T>? = null

    private fun leftRotate(node: AVLNode<T>) : AVLNode<T> {
        // Right child is chosen as the pivot. It moves a level up.
        var pivot = node.rightChild!!

        // Node to be rotated, becomes the left child of the pivot. It moves a level down.
        node.rightChild = pivot.leftChild

        // This means current left child of the pivot must be moved elsewhere.
        // pivots left child can be set to rotated node
        pivot.leftChild = node

        // update height of rotated node and pivot
        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1

        // replace pivot so it can replace rotated node in tree.
        return pivot
    }

    private fun rightRotate(node: AVLNode<T>): AVLNode<T> {
        val pivot = node.leftChild!!
        node.leftChild = pivot.rightChild
        pivot.rightChild = node
        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
        return pivot
    }
}