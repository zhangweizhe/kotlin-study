package offer.middle

import linkedlist.TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    // 剑指 Offer 32 - I. 从上到下打印二叉树
    // https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/

}

private fun levelOrder(root: TreeNode?): IntArray {
    if (root == null) {
        return intArrayOf()
    }
    val queue = LinkedList<TreeNode>()
    val resultList = ArrayList<Int>()
    queue.offer(root)
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val poll = queue.poll()
            resultList.add(poll.`val`)
            if (poll.left != null) {
                queue.offer(poll.left)
            }
            if (poll.right != null) {
                queue.offer(poll.right)
            }
        }
    }
    return IntArray(resultList.size) {
        resultList[it]
    }
}