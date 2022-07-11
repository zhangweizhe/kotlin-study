package offer.middle

import linkedlist.TreeNode
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    // 剑指 Offer 34. 二叉树中和为某一值的路径
    // https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
}

private fun pathSum(root: TreeNode?, target: Int): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    val path = LinkedList<Int>()
    dfs(root, target, result, path)
    return result
}

private fun dfs(root: TreeNode?, target: Int, result: ArrayList<ArrayList<Int>>, path: LinkedList<Int>) {
    if (root == null) {
        return
    }
    path.offer(root.`val`)
    // 题目要求是从根节点到叶子节点，所以加上 root.left == null && root.right == null 的判断
    if (root.`val` == target && root.left == null && root.right == null) {
        result.add(ArrayList(path))
    }
    dfs(root.left, target - root.`val`, result, path)
    dfs(root.right, target - root.`val`, result, path)
    path.pollLast()
}

