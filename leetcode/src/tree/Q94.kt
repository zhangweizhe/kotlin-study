package tree

import linkedlist.TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    // 94. 二叉树的中序遍历
    // https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
}

fun inorderTraversal(root: TreeNode?): List<Int> {

    if (root == null) {
        return ArrayList()
    }

    val ret = ArrayList<Int>()
    val stack = Stack<TreeNode>()
    var cur = root
    while (stack.isNotEmpty() || cur != null) {
        while (cur != null) {
            stack.push(cur)
            cur = cur.left
        }
        val node = stack.pop()
        ret.add(node.`val`)
        if (node.right != null) {
            cur = node.right
        }
    }
    return ret
}


fun inorderTraversal1(root: TreeNode?): List<Int> {

    if (root == null) {
        return ArrayList()
    }

    val ret = ArrayList<Int>()
    val stack = Stack<TreeNode>()
    var cur = root
    // 左链先入栈
    while (cur != null) {
        stack.push(cur)
        cur = cur.left
    }

    while (stack.isNotEmpty()) {
        val pop = stack.pop()
        ret.add(pop.`val`)
        cur = pop.right
        while (cur != null) {
            stack.push(cur)
            cur = cur.left
        }
    }
    return ret
}