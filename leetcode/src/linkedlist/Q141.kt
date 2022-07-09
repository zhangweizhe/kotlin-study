package linkedlist

import linkedlist.kt.ListNode

fun main() {
    // 环形链表
    // https://leetcode-cn.com/problems/linked-list-cycle/
}

/**
 * set集合解法
 */
fun hasCycle(head: ListNode?): Boolean {
    val set = mutableSetOf<ListNode>()
    var cur = head
    while (cur != null && cur !in set) {
        set.add(cur)
        cur = cur.next
    }
    if (cur == null) {
        return false
    }
    return true
}

/**
 * 快慢指针解法
 */
fun hasCycle1(head: ListNode?): Boolean {
    if (head == null) {
        return false
    }
    var fast = head.next
    var slow = head
    while (fast != slow) {
        if (fast?.next == null) {
            return false
        }
        fast = fast.next?.next
        slow = slow?.next
    }
    return true
}