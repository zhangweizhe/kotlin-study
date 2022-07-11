package linkedlist

import linkedlist.kt.ListNode

fun main() {
    val createList = LinkedListUtil.createList(intArrayOf(1, 4, 5, 6, 2, 3))
    LinkedListUtil.printLinkedList(deleteNode(createList, 3))
}

fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
    var fakeHead = ListNode(0)
    fakeHead.next = head
    var cur: ListNode? = fakeHead
    while (cur?.next != null) {
        if (cur.next?.`val` == `val`) {
            cur.next = cur.next?.next
            break
        }
        cur = cur.next
    }
    return fakeHead.next
}