package tree

import linkedlist.TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    // 94. 二叉树的中序遍历
    // https://leetcode-cn.com/problems/binary-tree-inorder-traversal/

    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(3)
    root.right?.left = TreeNode(4)
    root.right?.right = TreeNode(3)

    println(inorderTraversal3(root))
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

fun inorderTraversal2(root: TreeNode?): List<Int> {

    if (root == null) {
        return ArrayList()
    }

    var cur:TreeNode? = root
    val stack = Stack<TreeNode>()
    while (cur != null) {
        stack.push(cur)
        cur = cur.left
    }

    val ret = ArrayList<Int>()

    while (stack.isNotEmpty()) {
        val pop = stack.pop()
        ret.add(pop.`val`)

        if (pop.right != null) {
            cur = pop.right
        }
        while (cur != null) {
            stack.push(cur)
            cur = cur.left
        }
    }

    return ret
}








fun inorderTraversal3(root: TreeNode?): List<Int> {

    val list:ArrayList<Int> = ArrayList()

    if (root == null) {
        return list
    }

    val stack = Stack<TreeNode>()

    var p = root;
    while (p != null || stack.isNotEmpty()) {
        while (p != null) {
            stack.push(p)
            p = p.left
        }
        val pop = stack.pop()
        list.add(pop.`val`)
        p = pop.right
    }

    return list
}

private fun help(root: TreeNode?, list: ArrayList<Int>) {
    if (root == null) {
        return
    }
    help(root.left, list)
    list.add(root.`val`)
    help(root.right, list)
}