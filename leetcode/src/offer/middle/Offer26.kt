package offer.middle

import linkedlist.TreeNode

fun main() {
    // 剑指 Offer 26. 树的子结构
    // https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/

}

fun isSubStructure(A: TreeNode?, B: TreeNode?): Boolean {
    if (A == null || B == null) {
        return false
    }
    // isSub(A, B) 判断 B 是不是以 A 为根节点的树的子结构
    // 如果不是，则 isSubStructure(A.left, B)，判断 B 是不是 A.left 的子结构
    // 如果不是，则 isSubStructure(A.right, B)，判断 B 是不是 A.right 的子结构
    return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)
}

/**
 * 判断[A]和[B]两棵树的结构是否一样，或者[B]是否是以[A]为根节点的树的子结构
 */
fun isSub(A: TreeNode?, B: TreeNode?): Boolean {
    if (A == null && B == null) {
        return true
    }
    if (B == null) {
        // B 已经遍历完了，是 A 的子结构
        return true
    }
    if (A == null) {
        // A 已经遍历完了，B 还没遍历完（B!=null），B 不是 A 的子结构
        return false
    }
    if (A.`val` != B.`val`) {
        // A B 的值不一样
        return false
    }
    // A B 的值一样，比较 (A.left, B.left) 和 (A.right, B.right)
    return isSub(A.left, B.left) && isSub(A.right, B.right)
}