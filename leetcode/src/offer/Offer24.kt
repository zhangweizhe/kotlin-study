package offer

import linkedlist.LinkedListUtil
import linkedlist.ListNode

fun main() {
    // 剑指 Offer 24. 反转链表
    // https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/

    val createList = LinkedListUtil.createList(intArrayOf(1, 2, 3, 4))
    LinkedListUtil.printLinkedList(reverseList(createList))
}

fun reverseList(head: ListNode?): ListNode? {

    var prev:ListNode? = null
    var cur = head
    var next: ListNode? = null

    while (cur != null) {
        next = cur.next
        cur.next = prev
        prev = cur
        cur = next
    }

    return prev
}