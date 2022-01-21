import tree.TreeNode

fun main(args: Array<String>) {
    println("Hello World!")

    val java = TreeNode("Java")
    val python = TreeNode("Python")

    val languages = TreeNode("Languages")

    languages.add(java)
    languages.add(python)
    java.add(TreeNode("java 1.8"))

    languages.dfs{it -> println(it.value)}
    println("---")
    languages.bfs { println(it.value) }
}