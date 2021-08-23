package linkedlist

fun main() {
    // 2. 两数相加
    // https://leetcode-cn.com/problems/add-two-numbers/

    val p1 = LinkedListUtil.createList(intArrayOf(9,9,9,9,9,9,9))
    val p2 = LinkedListUtil.createList(intArrayOf(9,9,9,9))

    LinkedListUtil.printLinkedList(addTwoNumbers(p1, p2))
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var p1 = l1
    var p2 = l2
    // 1 10 100 1000 ...
    var factor = 1
    // 和
    var sum = 0
    // 进位
    var addition = 0
    val dummyHead = ListNode(0)
    var cur = dummyHead
    while (p1 != null && p2 != null) {
        var tmp = p1.`val` + p2.`val` + addition
        sum += ((tmp % 10) * factor)
        addition = tmp / 10
        p1 = p1.next
        p2 = p2.next
        factor *= 10
        cur.next = ListNode(tmp % 10)
        cur = cur.next!!
    }

    var pNoNull:ListNode? = p1 ?: p2

    while (pNoNull != null) {
        val tmp = pNoNull.`val` + addition
        cur.next = ListNode(tmp % 10)

        sum += ((tmp % 10) * factor)

        addition = tmp / 10
        cur = cur.next!!
        factor *= 10
        pNoNull = pNoNull.next
    }
    if (addition != 0) {
        cur.next = ListNode(addition)
        sum += addition * factor
    }
    println(sum)

    return dummyHead.next
}