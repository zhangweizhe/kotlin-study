package linkedlist

import linkedlist.kt.ListNode

fun main() {
    // 234. 回文链表
    // https://leetcode-cn.com/problems/palindrome-linked-list/

    val createList = LinkedListUtil.createList(intArrayOf(1, 2, 1))

    println(isPalindrome1(createList))

}

/**
 * 把原链表反转，构造一个新链表，对比新旧链表的每个节点的值是否一样
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
private fun isPalindrome(head: ListNode?): Boolean {
    var cur = head
    var newHead: ListNode? = null
    while (cur != null) {
        var newNode = ListNode(cur.`val`)
        newNode.next = newHead
        newHead = newNode
        cur = cur.next
    }

    var tmp = newHead
    while (tmp != null) {
        println(tmp.`val`)
        tmp = tmp.next
    }

    cur = head

    while (cur != null && newHead != null) {
        if (cur.`val` != newHead.`val`) {
            return false
        }
        cur = cur.next
        newHead = newHead.next
    }

    return true
}

/**
 * 先找到右半部分的链表，将其反转，然后对比左右两半的链表，每个值是否一致
 * 时间复杂度O(n)
 * 空间复杂度O(1)，反转是在原链表反转的，不消耗额外的空间
 */
fun isPalindrome1(head: ListNode?): Boolean {
    val rightHalf = LinkedListUtil.getRightHalf(head)
    var rightP = rightHalf
    var leftP = head
    rightP = LinkedListUtil.reverseListLocal(rightP)

    while (rightP != null && leftP != null) {
        if (rightP.`val` != leftP.`val`) {
            return false
        }
        rightP = rightP.next
        leftP = leftP.next
    }

    return true
}

