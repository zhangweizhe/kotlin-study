package linkedlist

import linkedlist.kt.ListNode

fun main() {
    // 206. 反转链表
    // https://leetcode-cn.com/problems/reverse-linked-list/
    val createList = LinkedListUtil.createList(intArrayOf(1, 2, 3, 4, 5))
    LinkedListUtil.printLinkedList(reverseList(createList))
}

/**
 * 反转链表，返回一个新的链表
 */
fun reverseList1(head: ListNode?): ListNode? {
    var cur: ListNode? = head
    var newHead: ListNode? = null
    while (cur != null) {
        val newNode = ListNode(cur.`val`)
        newNode.next = newHead
        newHead = newNode
        cur = cur.next
    }
    return newHead
}

/**
 * 反转链表，在原链表上操作
 */
fun reverseListLocal(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var cur = head
    while (cur != null) {
        // 保存 cur 的后继节点
        var next = cur.next
        // cur 的前驱节点指向 prev
        cur.next = prev
        // prev 往右走一步
        prev = cur
        // cur 往右走一步
        cur = next
    }
    return prev
}

private fun reverseList(head: ListNode?): ListNode? {

    // https://leetcode-cn.com/problems/reverse-linked-list/solution/shi-pin-jiang-jie-die-dai-he-di-gui-hen-hswxy/
    if (head == null || head.next == null) {
        return head
    }

    // 处理当前节点之后的节点
    val next = reverseList(head.next)
    // 处理当前节点
    // 当前节点的next节点的next节点指向当前节点
    head.next?.next = head
    // 当前节点的 next 节点置null，否则会出现环
    head.next = null

    return next
}