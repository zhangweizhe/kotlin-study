package tree

import linkedlist.TreeNode
import java.util.*
import kotlin.math.max

fun main() {
    // 104. 二叉树的最大深度
    // https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/


    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.right = TreeNode(7)
    root.right?.left = TreeNode(15)

    println(maxDepth(root))
}

fun maxDepth(root: TreeNode?): Int {

    if (root == null) {
        return 0
    }

    val queue = LinkedList<TreeNode>()
    queue.add(root)
    var ret = 0
    while (queue.isNotEmpty()) {
        val n = queue.size
        for (i in 0 until n) {
            val poll = queue.poll()
            if (poll.left != null) {
                queue.add(poll.left!!)
            }
            if (poll.right != null) {
                queue.add(poll.right!!)
            }
        }
        ret++
    }
    return ret
}