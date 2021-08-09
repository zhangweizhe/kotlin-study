package linkedlist

fun main() {
    // 82. 删除排序链表中的重复元素 II
    // https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
    val createList = LinkedListUtil.createList(intArrayOf(1, 2, 3, 3, 3, 4, 4, 5, 5))
    LinkedListUtil.printLinkedList(deleteDuplicates(createList))
}

private fun deleteDuplicates(head: ListNode?): ListNode? {
    var dummyHead = ListNode(0)
    dummyHead.next = head
    var cur:ListNode? = dummyHead

    while (cur?.next != null && cur.next?.next != null) {
        if (cur.next?.`val` == cur.next?.next?.`val`) {
            val tmp = cur.next?.`val`
            while (tmp == cur.next?.`val`) {
                cur.next = cur.next?.next
            }
        }else {
            cur = cur.next
        }
    }
    return dummyHead.next
}