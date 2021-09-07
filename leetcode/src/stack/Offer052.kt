package stack

import linkedlist.TreeNode
import java.util.*

fun main() {
    // 剑指 Offer II 052. 展平二叉搜索树
    // https://leetcode-cn.com/problems/NYBBNL/
    val root = TreeNode(5)

    root.left = TreeNode(3)
    root.left?.left = TreeNode(2)
    root.left?.right = TreeNode(4)
    root.left?.left?.left = TreeNode(1)

    root.right = TreeNode(6)
    root.right?.right = TreeNode(8)
    root.right?.right?.left = TreeNode(7)
    root.right?.right?.right = TreeNode(9)

    var increasingBST = increasingBST(root)
    while (increasingBST != null) {
        println(increasingBST.`val`)
        increasingBST = increasingBST.right
    }
}

fun increasingBST(root: TreeNode?): TreeNode? {

    if (root == null) {
        return null
    }
    val stack = Stack<TreeNode>()
    var cur = root
    while (cur != null) {
        stack.push(cur)
        cur = cur.left
    }

    var prev:TreeNode? = null
    var ret:TreeNode = TreeNode(0)

    while (stack.isNotEmpty()) {
        val pop = stack.pop()
        if (prev == null) {
            prev = pop
            ret.right = pop
        }else {
            prev.right = pop
            prev = pop
            pop.left = null
        }
//        println(pop.`val`)
        if (pop.right != null) {
            cur = pop.right
            while (cur != null) {
                stack.push(cur)
                cur = cur.left
            }
        }
    }
    return ret.right
}
