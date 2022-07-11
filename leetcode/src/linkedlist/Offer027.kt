package linkedlist

import linkedlist.kt.ListNode

fun main() {

}

private fun isPalindrome(head: ListNode?): Boolean {
    val findRightHalf = findRightHalf(head)
    val reverse = reverse(findRightHalf)
    var left = head
    var right = reverse
    while (left != null && right != null) {
        if (left.`val` != right.`val`) {
            return false
        }
        left = left.next
        right = right.next
    }
    return true
}

private fun findRightHalf(head: ListNode?): ListNode? {
    var fast: ListNode? = head
    var slow: ListNode? = head
    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    if (fast == null) {
        return slow
    }
    return slow?.next
}

private fun reverse(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var cur = head
    while (cur != null) {
        val next = cur.next
        cur.next = prev
        prev = cur
        cur = next
    }
    return prev
}