package offer

import linkedlist.TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun main() {

    val root = TreeNode(3)
    root.left = TreeNode(1)
    root.left?.right = TreeNode(2)
    root.right = TreeNode(4)

    println(kthLargest(root, 2))
}

fun kthLargest(root: TreeNode?, k: Int): Int {

    val stack = Stack<TreeNode>()
    var cur = root
    while (cur != null) {
        stack.push(cur)
        cur = cur.right
    }
    var count = k

    while (stack.isNotEmpty()) {
        val pop = stack.pop()
        count--
        if (count == 0) {
            return pop.`val`
        }
        if (pop.left != null) {
            cur = pop.left
            while (cur != null) {
                stack.push(cur)
                cur = cur.right
            }
        }
    }

    return 0
}