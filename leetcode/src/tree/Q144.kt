package tree

import linkedlist.TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    // 144. 二叉树的前序遍历
    // https://leetcode-cn.com/problems/binary-tree-preorder-traversal/


    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(3)

    root.right = TreeNode(4)
    root.right?.right = TreeNode(5)

    println(preorderTraversal2(root))


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

fun preorderTraversal1(root: TreeNode?): List<Int> {

    if (root == null) {
        return ArrayList()
    }

    val ret = ArrayList<Int>()
    val stack = Stack<TreeNode>()
    stack.push(root)

    while (stack.isNotEmpty()) {
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


fun preorderTraversal2(root: TreeNode?): List<Int> {
    if (root == null) {
        return ArrayList()
    }

    var p = root
    val stack = Stack<TreeNode>()
    val rest = ArrayList<Int>()
    while (p != null || stack.isNotEmpty()) {
        if (p != null) {
            rest.add(p.`val`)
        }
        if (p != null) {
            if (p.right != null) {
                stack.push(p.right)
            }
        }
        if (p != null) {
            if (p.left != null) {
                stack.push(p.left)
            }
        }
        p = if (stack.isNotEmpty()) {
            stack.pop()
        }else {
            null
        }
    }
    return rest;
}