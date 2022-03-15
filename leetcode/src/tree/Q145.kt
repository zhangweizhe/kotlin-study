package tree

import linkedlist.TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    // 145. 二叉树的后序遍历
    // https://leetcode-cn.com/problems/binary-tree-postorder-traversal/

    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(3)

    root.right = TreeNode(4)
    root.right?.right = TreeNode(5)

    println(postorderTraversal2(root))
}

fun postorderTraversal(root: TreeNode?): List<Int> {

    if (root == null) {
        return ArrayList()
    }

    val stack = Stack<TreeNode>()
    val ret = ArrayList<Int>()

    var cur = root
    // 记录上一次处理的节点
    var prev:TreeNode? = null

    while (stack.isNotEmpty() || cur != null) {

        // 左链加入栈中
        while (cur != null && prev != cur) {
            stack.push(cur)
            cur = cur.left
        }

        val pop = stack.pop()
        if (pop.right != null && pop.right != prev) {
            // pop 的右节点不为Null，且 != prev，表示 pop 的右子树还没有遍历
            // cur 指向 pop 的右节点，开始遍历右子树
            cur = pop.right
            // 把 pop 加回栈中
            stack.push(pop)
        }else {
            // pop 没有右节点，或者右节点 == prev，表示 pop 的右子树已经遍历完成，回到了 pop 节点
            // 所以把 pop 节点加入结果集中
            ret.add(pop.`val`)
            // prev 指向 pop 节点
            prev = pop

        }
    }

    return ret
}




fun postorderTraversal1(root: TreeNode?): List<Int> {
    if (root == null) {
        return ArrayList()
    }

    var prev:TreeNode? = null
    var curr = root
    val ret = ArrayList<Int>()

    val stack = Stack<TreeNode>()
    while (curr != null) {
        stack.push(curr)
        curr = curr.left
    }

    while (stack.isNotEmpty()) {
        val pop = stack.pop()
        if (pop.right != null && pop.right != prev) {
            stack.push(pop)
            curr = pop.right
            while (curr != null) {
                stack.push(curr)
                curr = curr.left
            }
        }else {
            ret.add(pop.`val`)
            prev = pop
        }
    }

    return ret
}

fun postorderTraversal2(root: TreeNode?): List<Int> {

    if (root == null) {
        return ArrayList()
    }

    val ret = ArrayList<Int>()
    val stack = Stack<TreeNode>()

    var p = root
    var prev:TreeNode? = null

    while (p != null || stack.isNotEmpty()) {
        while (p != null) {
            stack.push(p)
            p = p.left
        }

        val pop = stack.pop()
        if (pop.right == null || pop.right == prev) {
            // pop.right == null 没有右子树
            // pop.right == prev，有右子树，右子树遍历过了
            // 处理（加入结果集）当前节点
            ret.add(pop.`val`)
            prev = pop
        }else {
            // 有右子树，且还没有遍历
            p = pop.right
            stack.push(pop)
        }
    }

    return ret
}