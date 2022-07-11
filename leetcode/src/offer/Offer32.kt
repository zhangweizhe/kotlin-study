package offer

import linkedlist.TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    // 剑指 Offer 32 - II. 从上到下打印二叉树 II
    // https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
    val root = TreeNode(3)

    root.left = TreeNode(9)
    root.right = TreeNode(20)

    root.left?.right = TreeNode(8)

    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)

    val levelOrder = levelOrder1(root)
    levelOrder.forEach {
        println(it.toString())
    }
}

/**
 * 循环实现，借助队列先进先出的特性
 */
fun levelOrder1(root: TreeNode?): List<List<Int>> {

    val result = ArrayList<MutableList<Int>>()

    if (root == null) {
        return result
    }

    val queue = LinkedList<TreeNode>()
    queue.offer(root)
    while (!queue.isEmpty()) {
        val tmpList = ArrayList<Int>()
        val queueSize = queue.size
        for (i in 0 until queueSize) {
            val poll = queue.poll()
            tmpList.add(poll.`val`)
            if (poll.left != null) {
                queue.offer(poll.left)
            }
            if (poll.right != null) {
                queue.offer(poll.right)
            }
        }
        result.add(tmpList)
    }

    return result
}

/**
 * 递归实现
 */
fun levelOrder(root: TreeNode?): List<List<Int>> {

    val result = ArrayList<MutableList<Int>>()

    help(root, 0, result)

    return result
}

fun help(root: TreeNode?, layer: Int, result: MutableList<MutableList<Int>>) {

    if (root == null) {
        return
    }

    val currentLayer = if (layer >= result.size) {
        val list = ArrayList<Int>()
        result.add(layer, list)
        list
    }else {
        result.get(layer)
    }
    currentLayer.add(root.`val`)

    help(root.left, layer+1, result)
    help(root.right, layer+1, result)
}

