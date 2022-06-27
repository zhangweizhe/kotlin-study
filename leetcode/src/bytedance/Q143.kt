package bytedance

import linkedlist.LinkedListUtil
import linkedlist.ListNode

fun main() {
    val head = LinkedListUtil.createList(intArrayOf(1,2,3,4))
    reorderList(head)
    LinkedListUtil.printLinkedList(head)
}
fun reorderList(head: ListNode?): Unit {
    if (head==null || head.next==null)return
    val mid = middle(head)
    val l2 = reverse(mid.next!!)
    mid.next=null
    merge(head,l2)
}

fun middle(head:ListNode):ListNode{
    var slow = head
    var fast:ListNode? = head
    while(fast?.next != null && fast.next?.next != null){
        slow = slow.next!!
        fast = fast.next!!.next
    }
    return slow
}

fun reverse(head:ListNode):ListNode{
    var prev:ListNode?=null
    var cur:ListNode? = head
    while(cur != null){
        val tmp:ListNode? = cur.next
        cur.next = prev
        prev = cur
        cur = tmp
    }
    return prev!!
}
fun merge(l1:ListNode,l2:ListNode):ListNode{
    var c1:ListNode? = l1
    var c2:ListNode? = l2
    while(c1!=null&&c2!=null){
        val tmp1 = c1.next
        val tmp2 = c2.next
        c1.next = c2
        c2.next = tmp1
        c2 = tmp2
        c1 = tmp1
    }
    return l1
}