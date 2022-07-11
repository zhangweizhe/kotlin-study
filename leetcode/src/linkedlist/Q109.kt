package linkedlist

import linkedlist.kt.ListNode

fun main() {
    // 109. 有序链表转换二叉搜索树
    // https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
    val createList = LinkedListUtil.createList(intArrayOf(-10, -3, 0, 5, 9))
    println(sortedListToBST(createList)?.`val`)
}

private fun sortedListToBST(head: ListNode?): TreeNode? {
    if (head == null) {
        return null
    }
    if (head.next == null) {
        return TreeNode(head.`val`)
    }
    var fast = head
    val dummyHead = ListNode(0)
    dummyHead.next = head
    var slow: ListNode? = dummyHead
    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    val mid = slow?.next
    slow?.next = null
    val root = mid?.`val`?.let { TreeNode(it) }
    root?.left = sortedListToBST(dummyHead.next)
    // mid作为根节点，所以应该取mid.next作为右节点
    root?.right = sortedListToBST(mid?.next)
    return root
}