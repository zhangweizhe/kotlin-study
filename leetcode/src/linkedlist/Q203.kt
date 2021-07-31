package linkedlist

fun main() {
    // 203. 移除链表元素
    // https://leetcode-cn.com/problems/remove-linked-list-elements/

}

fun removeElements(head: ListNode?, `val`: Int): ListNode? {
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