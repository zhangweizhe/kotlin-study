package linkedlist

import linkedlist.kt.ListNode

fun main() {
    // 面试题 02.01. 移除重复节点
    // https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
    val createList = LinkedListUtil.createList(intArrayOf(1, 2, 3, 2, 1))
    val removeDuplicateNodes = removeDuplicateNodes1(createList)
    LinkedListUtil.printLinkedList(removeDuplicateNodes)
}

/**
 * 哈希表法
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
fun removeDuplicateNodes(head: ListNode?): ListNode? {
    val set = hashSetOf<Int?>()
    var fakeHead = ListNode(0)
    fakeHead.next = head
    var cur: ListNode? = fakeHead
    while (cur?.next != null) {
        if (cur.next?.`val` in set) {
            cur.next = cur.next?.next
        }else {
            set.add(cur.next?.`val`)
            cur = cur.next
        }
    }
    return fakeHead.next
}

/**
 * 双重循环
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
fun removeDuplicateNodes1(head: ListNode?): ListNode? {
    val fakeHead = ListNode(0)
    fakeHead.next = head
    var x: ListNode? = fakeHead
    while (x?.next != null) {
        var y: ListNode? = x.next
        while (y?.next != null) {
            if (x.next?.`val` == y.next?.`val`) {
                y.next = y.next?.next
            }else {
                y = y.next
            }
        }
        x = x.next
    }
    return fakeHead.next
}