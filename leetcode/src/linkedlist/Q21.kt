package linkedlist

fun main() {
    // https://leetcode-cn.com/problems/merge-two-sorted-lists/
    val l1 = LinkedListUtil.createList(intArrayOf(1, 2, 4))
    val l2 = LinkedListUtil.createList(intArrayOf(1, 3, 4))
    LinkedListUtil.printLinkedList(mergeTwoLists(l1, l2))
}

/**
 * 递归
 */
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    when {
        l1 == null -> {
            return l2
        }
        l2 == null -> {
            return l1
        }
        l1.`val` < l2.`val` -> {
            l1.next = mergeTwoLists(l1.next, l2)
            return l1
        }
        else -> {
            l2.next = mergeTwoLists(l1, l2.next)
            return l2
        }
    }
}

/**
 * 双指针
 */
fun mergeTwoLists1(l1: ListNode?, l2: ListNode?): ListNode? {
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