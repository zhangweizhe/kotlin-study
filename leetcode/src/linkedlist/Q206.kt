package linkedlist

fun main() {
    // 206. 反转链表
    // https://leetcode-cn.com/problems/reverse-linked-list/
}

/**
 * 反转链表，返回一个新的链表
 */
fun reverseList(head: ListNode?):ListNode? {
    var cur:ListNode? = head
    var newHead:ListNode? = null
    while (cur != null) {
        val newNode = ListNode(cur.`val`)
        newNode.next = newHead
        newHead = newNode
        cur = cur.next
    }
    return newHead
}

/**
 * 反转链表，在原链表上操作
 */
fun reverseListLocal(head: ListNode?):ListNode? {
    var prev:ListNode? = null
    var cur = head
    while (cur != null) {
        // 保存 cur 的后继节点
        var next = cur.next
        // cur 的前驱节点指向 prev
        cur.next = prev
        // prev 往右走一步
        prev = cur
        // cur 往右走一步
        cur = next
    }
    return prev
}