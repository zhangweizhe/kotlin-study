package linkedlist

fun main() {
    // 86. 分隔链表
    // https://leetcode-cn.com/problems/partition-list/

    val createList = LinkedListUtil.createList(intArrayOf(1, 4, 3, 2, 5, 2))
    LinkedListUtil.printLinkedList(partition(createList, 3))
}

private fun partition(head: ListNode?, x: Int): ListNode? {
    var small:ListNode? = ListNode(0)
    var smallHead:ListNode? = small
    var large:ListNode? = ListNode(0)
    var largeHead:ListNode? = large

    var cur = head
    while (cur != null) {
        if (cur.`val` < x) {
            small?.next = cur
            small = small?.next
        }else {
            large?.next = cur
            large = large?.next
        }
        cur = cur.next
    }
    large?.next = null
    small?.next = largeHead?.next
    return smallHead?.next
}