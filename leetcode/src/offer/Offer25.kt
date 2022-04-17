package offer

import linkedlist.LinkedListUtil
import linkedlist.ListNode

class Offer25 {


}

fun main() {
    // 剑指 Offer 25. 合并两个排序的链表
    // https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
    val l1 = LinkedListUtil.createList(intArrayOf(1,3,5))
    val l2 = LinkedListUtil.createList(intArrayOf(2,4,5,6))
    val mergeTwoLists = mergeTwoLists(l1, l2)
    LinkedListUtil.printLinkedList(mergeTwoLists)
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

    var p1 = l1
    var p2 = l2
    var head = ListNode(-1)
    var cur: ListNode? = head

    while (p1 != null || p2 != null) {
        if (p1 != null && p2 != null) {
            if (p1.`val` > p2.`val`) {
                cur?.next = ListNode(p2.`val`)
                p2 = p2.next
            }else {
                cur?.next = ListNode(p1.`val`)
                p1 = p1.next
            }

        }else if (p1 != null) {
            cur?.next = ListNode(p1.`val`)
            p1 = p1.next
        }else if (p2 != null){
            cur?.next = ListNode(p2.`val`)
            p2 = p2.next
        }
        cur = cur?.next
    }
    return head.next
}