package linkedlist

fun main() {
    // https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/

}

fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }
    var dup = head.`val`
    var cur = head.next
    var prev = head
    while (cur != null) {
        if (cur.`val` == dup) {
            prev?.next = cur.next
        }else {
            dup = cur.`val`
            prev = cur
        }
        cur = cur.next
    }
    return head
}

fun deleteDuplicates1(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }
    var cur = head
    while (cur?.next != null) {
        if (cur.`val` == cur.next?.`val`) {
            cur.next = cur.next?.next
        }else{
            cur = cur.next
        }
    }
    return head
}