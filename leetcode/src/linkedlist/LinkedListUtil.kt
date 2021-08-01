package linkedlist

object LinkedListUtil {

    /**
     * 获取链表的右半部分
     * 如果是偶数个，如1 2 3 4，则返回3 4
     * 如果是奇数个，如1 2 3，则返回3
     */
    @JvmStatic
    fun getRightHalf(head: ListNode?): ListNode? {
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

    /**
     * 根据传入的数组，创建一个链表，返回链表头
     */
    @JvmStatic
    fun createList(array:IntArray):ListNode? {
        var dummyHead = ListNode(0)
        var cur = dummyHead

        for (i in array) {
            val node = ListNode(i)
            cur.next = node
            cur = node
        }

        return dummyHead.next
    }

    /**
     * 反转链表，返回一个新的链表
     */
    @JvmStatic
    fun reverseList(head: ListNode?):ListNode? {
        var cur:ListNode? = head
        var newHead:ListNode? = null
        while (cur != null) {
            val newNode = ListNode(cur.`val`)
            newNode.next = newHead
            newHead = newNode
            cur = cur.next
        }
        return newHead
    }

    /**
     * 反转链表，在原链表上操作
     */
    @JvmStatic
    fun reverseListLocal(head: ListNode?):ListNode? {
        var prev:ListNode? = null
        var cur = head
        while (cur != null) {
            // 保存 cur 的后继节点
            var next = cur.next
            // cur 的前驱节点指向 prev
            cur.next = prev
            // prev 往右走一步
            prev = cur
            // cur 往右走一步
            cur = next
        }
        return prev
    }

    /**
     * 打印链表
     */
    @JvmStatic
    fun printLinkedList(head: ListNode?) {
        var cur = head
        while (cur != null) {
            print("${cur.`val`} ")
            cur = cur.next
        }
        println()
    }
}