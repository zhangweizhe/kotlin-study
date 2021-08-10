package linkedlist

fun main() {
    // 92. 反转链表 II
    // https://leetcode-cn.com/problems/reverse-linked-list-ii/
    val createList = LinkedListUtil.createList(intArrayOf(5))
    LinkedListUtil.printLinkedList(reverseBetween(createList, 1, 1))
}

/**
 * 示例：1，2，3，4，5 left=2, right=4
 * 分别找到左半部分的尾结点(1)，需要反转的链表的头结点（2）、尾结点（4）、以及右半部分的头结点（5）
 * 把链表切成左中右3段
 * 反转中间的一段
 * 重新拼接3段
 */
fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
    var dummyHead = ListNode(0)
    dummyHead.next = head
    var leftTail:ListNode? = dummyHead
    var leftCount = 1
    while (leftCount < left) {
        leftCount++
        leftTail = leftTail?.next
    }
    var rightHead = leftTail
    while (leftCount <= right) {
        rightHead = rightHead?.next
        leftCount++
    }

    // 需要反转的链表的尾结点
    var reverseTail = rightHead
    rightHead = rightHead?.next
    // 右边断开
    reverseTail?.next = null

    // 需要反转的链表的头结点
    var reverseHead = leftTail?.next
    // 左边断开
    leftTail?.next = null

    var reversePrev:ListNode? = null
    var reverseCur = reverseHead

    while (reverseCur != null) {
        val next = reverseCur.next
        reverseCur.next = reversePrev
        reversePrev = reverseCur
        reverseCur = next
    }

    leftTail?.next = reversePrev
    reverseHead?.next = rightHead

    return dummyHead.next
}