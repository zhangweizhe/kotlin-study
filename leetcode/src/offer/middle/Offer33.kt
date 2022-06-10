package offer.middle

fun main() {
    // 剑指 Offer 33. 二叉搜索树的后序遍历序列
    // https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
    println(verifyPostorder(intArrayOf(1,1,2,3,4,5)))
}

fun verifyPostorder(postorder: IntArray): Boolean {
    return help(postorder, 0, postorder.size - 1)
}

private fun help(postorder: IntArray, startIndex: Int, rootIndex: Int): Boolean {
    if (startIndex >= rootIndex) {
        return true
    }
    val rootVal = postorder[rootIndex]
    var i = startIndex
    // 找到第一个比 rootVal 大的元素的下标，由此划分左右子树
    while (postorder[i] < rootVal) {
        i++
    }
    // 验证右子树是否都大于 rootVal
    val rightTreeStartIndex = i
    while (postorder[i] > rootVal) {
        i++
    }
    return i == rootIndex && help(postorder, startIndex, rightTreeStartIndex - 1) && help(postorder, rightTreeStartIndex, rootIndex - 1)
}