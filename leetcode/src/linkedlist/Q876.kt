package linkedlist

import linkedlist.kt.ListNode

fun main() {
    // 876. 链表的中间结点
    // https://leetcode-cn.com/problems/middle-of-the-linked-list/

}

/**
 * 快慢指针
 */
fun middleNode(head: ListNode?): ListNode? {
    var fast = head
    var slow = head
    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    return slow
}