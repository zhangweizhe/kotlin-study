package linkedlist

fun main() {
    // 61. 旋转链表
    // https://leetcode-cn.com/problems/rotate-list/
    val createList = LinkedListUtil.createList(intArrayOf(1, 2))
    LinkedListUtil.printLinkedList(rotateRight1(createList, 1))
}

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    var length:Int = 0
    var cur = head
    var tail:ListNode? = null
    while (cur != null) {
        length++
        tail = cur
        cur = cur.next
    }
    if (length == 0) {
        return head
    }
    var rotateTime = k % length


    var tmpK = rotateTime
    var fast = head
    while (tmpK > 0) {
        fast = fast?.next
        tmpK--
    }

    var dummyHead = ListNode(0)
    dummyHead.next = head
    var slow = dummyHead
    while (fast != null) {
        slow = slow.next!!
        fast = fast.next
    }

    tail?.next = head
    var ret = slow.next
    slow.next = null
    return ret
}


fun rotateRight1(head: ListNode?, k: Int): ListNode? {
    var length = 0
    var cur:ListNode? = ListNode(0)
    cur?.next = head
    while (cur?.next != null) {
        cur = cur.next!!
        length++
    }
    if (length == 0) {
        return head
    }
    var times = k % length
    if (times == 0) {
        return head
    }

    cur?.next = head
    times = length - times
    while (times > 0) {
        cur = cur?.next
        times--
    }
    var ret = cur?.next
    cur?.next = null

    return ret
}