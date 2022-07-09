package linkedlist

import linkedlist.kt.ListNode

fun main() {
    // 剑指 Offer 06. 从尾到头打印链表
    // https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
    println(reversePrint(LinkedListUtil.createList(intArrayOf(1,3,2))).contentToString())
}

private fun reversePrint(head: ListNode?): IntArray {

    var count = 0

    var cur = head
    while (cur != null) {
        count++
        cur = cur.next
    }
    if (count == 0) {
        return IntArray(0)
    }

    cur = head
    val ret = IntArray(count)
    count--
    while (cur != null) {
        ret[count] = cur.`val`
        count--
        cur = cur.next
    }
    return ret
}