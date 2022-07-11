package offer.middle

import linkedlist.TreeNode

fun main() {
    // 剑指 Offer 07. 重建二叉树
    // https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/
    val root = buildTree(intArrayOf(3,9,20,15,7), intArrayOf(9,3,15,20,7))
    println(root?.`val`)
}

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {

    return help(preorder, inorder, 0, 0, preorder.size - 1)
}

private fun help(
        preorder: IntArray,
        inorder: IntArray,
        preorderRootIndex: Int,
        inorderStartIndex: Int,
        inorderEndIndex: Int): TreeNode? {
    if (inorderStartIndex > inorderEndIndex || inorderStartIndex < 0 || inorderEndIndex >= preorder.size) {
        return null
    }
    var inorderRootIndex = 0
    val rootVal = preorder[preorderRootIndex]
    for (i in inorderStartIndex .. inorderEndIndex) {
        if (rootVal == inorder[i]) {
            inorderRootIndex = i
            break
        }
    }
    val root = TreeNode(rootVal)
    root.left = help(preorder, inorder, preorderRootIndex + 1, inorderStartIndex, inorderRootIndex - 1)
    val leftChildrenCount = inorderRootIndex - inorderStartIndex
    root.right = help(preorder, inorder, preorderRootIndex + leftChildrenCount + 1, inorderRootIndex + 1, inorderEndIndex)
    return root
}







private fun helpReview(preorder: IntArray, inorder: IntArray, preorderRootIndex: Int, inorderStartIndex: Int, inorderEndIndex: Int): TreeNode? {
    if (inorderStartIndex > inorderEndIndex || inorderStartIndex < 0 || inorderEndIndex >= preorder.size) {
        return null
    }
    val rootValue = preorder[preorderRootIndex]
    val root = TreeNode(rootValue)
    var inorderRootIndex = 0
    for (i in inorderStartIndex..inorderEndIndex) {
        if (inorder[i] == rootValue) {
            inorderRootIndex = i
            break
        }
    }
    // 左子树递归
    root.left = helpReview(preorder, inorder, preorderRootIndex + 1, inorderStartIndex, inorderRootIndex-1)
    // 右子树递归
    val leftChildrenCount = inorderRootIndex - inorderStartIndex
    root.right = helpReview(preorder, inorder, preorderRootIndex + leftChildrenCount + 1, inorderRootIndex + 1, inorderEndIndex)
    return root
}