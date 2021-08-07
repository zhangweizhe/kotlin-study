package linkedlist

fun main() {
    // 19. 删除链表的倒数第 N 个结点
    // https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/

    val createList = LinkedListUtil.createList(intArrayOf(1, 2, 3, 4, 5))
    LinkedListUtil.printLinkedList(removeNthFromEnd(createList, 5))
}

private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val dummyHead = ListNode(0)
    var left:ListNode? = dummyHead
    left?.next = head
    var right = head
    var tmpN = n
    while (tmpN > 0) {
        right = right?.next
        tmpN--
    }
    while (right != null) {
        right = right.next
        left = left?.next
    }
    left?.next = left?.next?.next
    return dummyHead.next
}