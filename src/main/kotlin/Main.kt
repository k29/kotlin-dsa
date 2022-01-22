import tree.BinarySearchTree
import tree.TreeNode

fun main(args: Array<String>) {
    println("Hello World!")

    val bst = BinarySearchTree<Int>().apply {
        insert(3)
        insert(1)
        insert(4)
        insert(0)
        insert(2)
        insert(5)
    }
    bst.root?.inOrder { println(it) }
    println("Min is -> " + bst.findMin(bst.root)?.value)
    bst.remove(3)
    println("---")
    bst.root?.inOrder { println(it) }

}