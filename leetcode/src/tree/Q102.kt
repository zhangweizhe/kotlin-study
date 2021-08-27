package tree

import linkedlist.TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    // 102. 二叉树的层序遍历
    // https://leetcode-cn.com/problems/binary-tree-level-order-traversal/

    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.right = TreeNode(7)
    root.right?.left = TreeNode(15)

    println(levelOrder(root))
    println(levelOrder1(root))
}

fun levelOrder(root: TreeNode?): List<List<Int>> {

    val ret = ArrayList<ArrayList<Int>>()
    helper(ret, root, 0)
    return ret
}

private fun helper(ret:ArrayList<ArrayList<Int>>, root: TreeNode?, level:Int) {

    if (root == null) {
        return
    }

    if (level >= ret.size) {
        ret.add(ArrayList())
    }
    val curLevel = ret[level]

    curLevel.add(root.`val`)
    helper(ret, root.left, level + 1)
    helper(ret, root.right, level + 1)
}

private fun levelOrder1(root: TreeNode?): List<List<Int>> {

    val ret = ArrayList<ArrayList<Int>>()

    if (root == null) {
        return ret
    }

    val queue = LinkedList<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        // 遍历每一层之前，先每一层节点的数量
        val n = queue.size
        val list = ArrayList<Int>()
        // 再一个循环中，遍历完当前层的节点，并把当前层的节点的子节点加入队列
        for (i in 0 until n) {
            val poll = queue.poll()
            list.add(poll.`val`)
            if (poll.left != null) {
                queue.add(poll.left!!)
            }
            if (poll.right != null) {
                queue.add(poll.right!!)
            }
        }
        ret.add(list)
    }
    return ret
}