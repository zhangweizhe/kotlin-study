package linkedlist

fun main() {
    // 203. 移除链表元素
    // https://leetcode-cn.com/problems/remove-linked-list-elements/

    val createList = LinkedListUtil.createList(intArrayOf(1,2,3,4))
    LinkedListUtil.printLinkedList(removeElements(createList, 1))
}

/**
 * 迭代
 */
fun removeElements1(head: ListNode?, `val`: Int): ListNode? {
    if (head == null) {
        return null
    }
    var dummyHead = ListNode(0)
    dummyHead.next = head
    var cur:ListNode? = dummyHead
    while (cur?.next != null) {
        if (cur.next?.`val` == `val`) {
            cur.next = cur.next?.next
        }else {
            cur = cur.next
        }
    }
    return dummyHead.next
}

/**
 * 递归
 */
fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    if (head == null) {
        return null
    }
    head.next = removeElements(head.next, `val`)
    if (head.`val` != `val`) {
        return head
    }else {
        return head.next
    }
}
