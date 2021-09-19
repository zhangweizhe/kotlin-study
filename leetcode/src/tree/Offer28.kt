package tree

import linkedlist.TreeNode
import java.util.*

fun main() {
    // 剑指 Offer 28. 对称的二叉树
    // https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
//    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(3)
//    root.right?.left = TreeNode(4)
    root.right?.right = TreeNode(3)
    println(isSymmetric1(root))
}

private fun isSymmetric(root: TreeNode?): Boolean {
    // 递归
    return help(root, root)
}

private fun help(left: TreeNode?, right:TreeNode?):Boolean {
    if (left == null && right == null) {
        return true
    }
    if (left == null) {
        return false
    }
    if (right == null) {
        return false
    }
    if (right.`val` != left.`val`) {
        return false
    }
    return help(left.left, right.right) && help(left.right, right.left)
}

private fun isSymmetric1(root: TreeNode?): Boolean {
    // 迭代，借助队列结构，检验当前层的同时，把下一层的节点加入队列中，检验完了把当前层出队
    if (root == null) {
        return true
    }
    val queue = LinkedList<TreeNode?>()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val left = queue[i]
            val right = queue[size - 1 - i]
            if (left == null && right == null) {
                continue
            }
            if (left == null) {
                return false
            }
            if (right == null) {
                return false
            }
            if (left.`val` != right.`val`) {
                return false
            }
            // 把字节点再加进来
            queue.offer(left.left)
            queue.offer(left.right)
        }
        // 当前队列结构  （头）当前层 ｜ 下一层（尾）
        for (i in 0 until size) {
            // 把当前层poll出去
            queue.poll()
        }
    }
    return true
}