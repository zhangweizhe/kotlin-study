package linkedlist

fun main() {
    // 24. 两两交换链表中的节点
    // https://leetcode-cn.com/problems/swap-nodes-in-pairs/
    val createList = LinkedListUtil.createList(intArrayOf(1,2,3,4))
    LinkedListUtil.printLinkedList(swapPairs2(createList))
}

/**
 * 递归 https://lyl0724.github.io/2020/01/25/1/
 * 三部曲
 * 1.递归的终止条件
 * 2.递归要返回什么
 * 3.递归中要做什么
 */
fun swapPairs(head: ListNode?): ListNode? {
    if (head == null || head.next == null) {
        // 1.递归的终止条件，剩下0个或1个节点，无法进行交换的操作
        return head
    }
    // 一共三个节点 head-next-swapPairs(next.next)
    // 要交换成 next-head-swapPairs(next.next)
    var next:ListNode? = head.next
    head.next = swapPairs(next?.next)
    next?.next = head

    // 返回给上一级的，是当前已完成交互的链表的头结点，即next
    return next
}

/**
 * 迭代
 */
fun swapPairs1(head: ListNode?): ListNode? {
    var dummyHead:ListNode? = null
    var left:ListNode? = head
    var right:ListNode? = left?.next
    var prev:ListNode? = null
    if (right == null) {
        return head
    }

    while (left != null && right != null) {
        left.next = right.next
        right.next = left
        prev?.next = right

        if (dummyHead == null) {
            dummyHead = right
        }
        prev = left
        left = left.next
        right = left?.next
    }

    return dummyHead
}


/**
 * 迭代
 * 定义一个哑结点dummyHead
 * 定义一个tmp=dummyHead节点，如果tmp后面只有0个或1个节点，则不做交换，否则，交换tmp后面的两个节点
 * tmp -> node1 -> node2 -> ...
 * 转换为 tmp -> node2 -> node1 -> ...
 */
fun swapPairs2(head: ListNode?): ListNode? {
    var dummyHead = ListNode(0)
    dummyHead.next = head
    var tmp:ListNode? = dummyHead

    while (tmp?.next != null && tmp.next?.next != null) {
        var node1 = tmp.next
        var node2 = tmp.next?.next

        tmp.next = node2
        node1?.next = node2?.next
        node2?.next = node1
        tmp = node1
    }

    return dummyHead.next
}