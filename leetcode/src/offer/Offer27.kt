package offer

import linkedlist.TreeNode
import java.util.*

fun main() {
    // 剑指 Offer 27. 二叉树的镜像
    // https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/

}

fun mirrorTree(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    // 临时保存 root.left，因为执行了第二行代码猴，root.left 的值已经变了
    val tmp = root.left
    /*第二行*/root.left = mirrorTree(root.right)
    root.right = mirrorTree(tmp)
    return root
}


fun mirrorTree1(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    val stack = Stack<TreeNode>()
    stack.push(root)
    while (stack.isNotEmpty()) {
        val pop = stack.pop()
        if (pop.left != null) {
            stack.push(pop.left)
        }
        if (pop.right != null) {
            stack.push(pop.right)
        }
        val tmp = pop.left
        pop.left = pop.right
        pop.right = tmp
    }
    return root
}