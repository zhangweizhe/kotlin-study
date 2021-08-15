package linkedlist

fun main() {
    // 142. 环形链表 II
    // https://leetcode-cn.com/problems/linked-list-cycle-ii/
    val createList = LinkedListUtil.createList(intArrayOf(3, 2, 0, 4))
    val n2 = createList?.next
    n2?.next?.next?.next = n2
    println(detectCycle(createList)?.`val`)
}

fun detectCycle(head: ListNode?): ListNode? {

    var fast = head
    var slow:ListNode? = head

    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
        if (fast == slow) {
            break
        }
    }

    if (fast == null || fast.next == null) {
        return null
    }
    fast = head
    while (fast != slow) {
        fast = fast?.next
        slow = slow?.next
    }
    return fast
}