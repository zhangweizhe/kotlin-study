package linkedlist

fun main() {
    // https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
    // 160. 相交链表
}

/**
 * set 解法
 */
fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
    val set = mutableSetOf<ListNode>()
    var curA = headA
    while (curA != null) {
        set.add(curA)
        curA = curA.next
    }

    var curB = headB
    while (curB != null) {
        if (curB in set) {
            return curB
        }
        curB = curB.next
    }
    return null
}

/**
 * 双指针解法
 */
fun getIntersectionNode1(headA:ListNode?, headB:ListNode?):ListNode? {
    if (headA == null || headB == null) {
        return null
    }
    var pA = headA
    var pB = headB

    // 如果两个链表相交，则会在 pA == pB == 相交节点 时推出循环
    // 如果两个链表不相交，则会在 pA == pB == null 时退出循环
    while (pA != pB) {
        if (pA == null) {
            pA = headB
        }else {
            pA = pA.next
        }
        if (pB == null) {
            pB = headA
        }else {
            pB = pB.next
        }
    }
    return pA
}