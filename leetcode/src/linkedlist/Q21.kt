package linkedlist

fun main() {
    // https://leetcode-cn.com/problems/merge-two-sorted-lists/
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null && l2 == null) {
        return null
    }
    if (l1 == null) {
        return l2
    }
    if (l2 == null) {
        return l1
    }

    var head = ListNode(0)
    var cur = head
    var p1 = l1
    var p2 = l2
    while (p1 != null && p2 != null) {
        if (p1.`val` > p2.`val`) {
            cur.next = ListNode(p2.`val`)
            p2 = p2.next
        }else {
            cur.next = ListNode(p1.`val`)
            p1 = p1.next
        }
        cur = cur.next!!
    }

    if (p1 != null) {
        cur.next = p1
    }
    if (p2 != null) {
        cur.next = p2
    }

    return head.next
}