package tree

import queue.ArrayListQueue

/**
 * Class for TreeNode.
 */
class TreeNode<T>(val value: T) {
    /**
     * children array for a given node
     */
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    /**
     * Add a new node to the children array
     * languages.add(TreeNode(java))
     */
    fun add(child: TreeNode<T>) = children.add(child)

    /**
     * Depth first search.
     *
     * Takes a lambda function as an input.
     * Caller can do whatever they want once they reach the node.
     *
     * While calling call it with object.dfs()
     * languages.dfs{lambda}
     * Or it can be called as languages.dfs({println(it.value)})
     * Or languages.dfs() {println(it.value)}
     */
    fun dfs(visit: (TreeNode<T>) -> Unit) {
        visit(this)
        children.forEach {
            it.dfs(visit)
        }
    }

    /**
     * Breadth first search
     *
     * Takes a lambda function as an input.
     * Caller can do whatever they want once they reach the node.
     *
     * languages.bfs{lambda}
     */
    fun bfs(visit: (TreeNode<T>) -> Unit) {
        visit(this)
        val queue = ArrayListQueue<TreeNode<T>>()
        children.forEach {
            queue.enqueue(it)
        }

        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach {
                queue.enqueue(it)
            }
            node = queue.dequeue()
        }
    }

    /**
     * Search through the tree for a given node.
     * Note the use of lambda in this case.
     *
     * When lambda has a single parameter, it is "it"
     * https://kotlinlang.org/docs/lambdas.html#it-implicit-name-of-a-single-parameter
     */
    fun search(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null
        bfs {
            if (it.value == value) {
                result = it
            }
        }
        return result
    }
}

/*

Usage ->

val java = TreeNode("Java")
val python = TreeNode("Python")

val languages = TreeNode("Languages")

languages.add(java)
languages.add(python)
java.add(TreeNode("java 1.8"))

languages.dfs{it -> println(it.value)}
println("---")
languages.bfs { println(it.value) }

 */

