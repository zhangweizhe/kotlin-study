package tree

import linkedlist.TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    // 144. 二叉树的前序遍历
    // https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
}

fun preorderTraversal(root: TreeNode?): List<Int> {

    if (root == null) {
        return ArrayList()
    }

    val ret = ArrayList<Int>()

    val stack = Stack<TreeNode>()
    stack.push(root)
    while (!stack.isEmpty()) {
        val pop = stack.pop()
        ret.add(pop.`val`)
        if (pop.right != null) {
            stack.push(pop.right)
        }
        if (pop.left != null) {
            stack.push(pop.left)
        }
    }

    return ret
}