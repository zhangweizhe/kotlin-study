package linkedlist

fun main() {
    // 114. 二叉树展开为链表
    // https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
    // TODO: 2021/8/14 未完成
    val root:TreeNode = TreeNode(1)

    val t2 = TreeNode(2)
    root.left = t2
    val t5 = TreeNode(5)
    root.right = t5

    val t3 = TreeNode(3)
    val t4 = TreeNode(4)
    t2.left = t3
    t2.right = t4

    val t6 = TreeNode(6)
    t5.right = t6

    flatten(root)
}

private fun flatten(root: TreeNode?): Unit {
    val helper = helper(root)
    println(helper?.`val`)
}

private fun helper(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    if (root.left == null && root.right == null) {
        return root
    }
    var tmp:TreeNode? = helper(root.right)
    root.right = helper(root.left)
    root.left = null
    root.right?.right = tmp
    return root
}