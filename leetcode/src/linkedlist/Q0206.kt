package linkedlist

fun main() {


    val createList = LinkedListUtil.createList(intArrayOf(1, 2, 1))

    println(isPalindrome2(createList))
}

private fun isPalindrome2(head: ListNode?): Boolean {
    var rightHalf = getRightHalfIn(head)
    var reverse = reverse(rightHalf)

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

fun getRightHalfIn(head: ListNode?): ListNode? {
    var fast = head
    var slow = head
    while (fast != null && fast.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    if (fast == null) {
        return slow
    }
    return slow?.next
}

fun reverse(head: ListNode?):ListNode? {
    var prev:ListNode? = null
    var cur:ListNode? = head
    while (cur != null) {
        var next = cur.next
        cur.next = prev
        prev = cur
        cur = next
    }
    return prev
}