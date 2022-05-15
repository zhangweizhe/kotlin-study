package offer

import linkedlist.TreeNode

fun main() {
    // 剑指 Offer 55 - II. 平衡二叉树
    // https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/
    val root = TreeNode(4)
    root.left = TreeNode(3)
    root.left?.left = TreeNode(2)
    root.right = TreeNode(1)
    println(isBalanced(root))
}

fun isBalanced(root: TreeNode?): Boolean {
    return depth(root) != -1
}

fun depth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    // 遍历左子树
    val leftDepth = depth(root.left)
    if (leftDepth == -1) {
        // 剪枝
        return -1
    }
    // 遍历右子树
    val rightDepth = depth(root.right)
    if (rightDepth == -1) {
        // 剪枝
        return -1
    }
    return if (Math.abs(leftDepth - rightDepth) > 1) {
        // 高度差大于1，返回-1，剪枝
        -1
    }else {
        // 高度差<=1，正常返回
        Math.max(leftDepth, rightDepth) + 1
    }
}