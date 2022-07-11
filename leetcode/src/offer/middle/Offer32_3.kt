package offer.middle

import linkedlist.TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    // 剑指 Offer 32 - III. 从上到下打印二叉树 III
    // https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
}

private fun levelOrder(root: TreeNode?): List<List<Int>> {

    if (root == null) {
        return ArrayList()
    }
    val queue = LinkedList<TreeNode>()
    queue.offer(root)
    var toRight = true
    val result = ArrayList<ArrayList<Int>>()
    while (queue.isNotEmpty()) {
        val tmpQ = LinkedList<Int>()
        val size = queue.size
        for (i in 0 until size) {
            val poll = queue.poll()
            if (toRight) {
                tmpQ.offer(poll.`val`)
            }else {
                tmpQ.offerFirst(poll.`val`)
            }
            if (poll.left != null) {
                queue.offer(poll.left)
            }
            if (poll.right != null) {
                queue.offer(poll.right)
            }
        }
        toRight = !toRight
        result.add(ArrayList(tmpQ))
    }
    return result
}