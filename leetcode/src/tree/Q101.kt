package tree

import linkedlist.TreeNode
import java.util.*

fun main() {
    // 101. 对称二叉树
    // https://leetcode-cn.com/problems/symmetric-tree/
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
    root.left?.left = TreeNode(3)
//    root.left?.right = TreeNode(3)
//    root.right?.left = TreeNode(4)
    root.right?.right = TreeNode(3)
    println(isSymmetric(root))
}

/**
 * 递归
 */
private fun isSymmetric(root: TreeNode?): Boolean {
    return help(root, root)
}

private fun help(left: TreeNode?, right: TreeNode?):Boolean {
    if (left == null && right == null) {
        return true
    }
    if (left == null || right == null) {
        return false
    }
    if (left.`val` != right.`val`) {
        return false
    }
    return help(left.left, right.right) && help(left.right, right.left)
}

/**
 * 迭代
 */
private fun isSymmetric1(root: TreeNode?): Boolean {

    if (root == null) {
        return true
    }

    val queue = LinkedList<TreeNode?>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            if (queue[i] == null && queue[size - i - 1] == null) {
                continue
            }
            if (queue[i]?.`val` != queue[size - i - 1]?.`val`) {
                return false
            }
            // 遍历每一层时，只peek
            val peek = queue[i]
            queue.add(peek?.left)
            queue.add(peek?.right)
        }
        // 一层遍历完了，再统一poll
        for (i in 0 until size) {
            queue.poll()
        }
    }
    return true
}
