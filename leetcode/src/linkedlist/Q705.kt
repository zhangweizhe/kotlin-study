package linkedlist

fun main() {
    // 705. 设计哈希集合
    // https://leetcode-cn.com/problems/design-hashset/
    var myHashSet = MyHashSet()
    myHashSet.add(1)
    myHashSet.add(1)
    myHashSet.add(4)
    myHashSet.add(3)
    LinkedListUtil.printLinkedList(myHashSet.head)
    println(myHashSet.contains(2))

    myHashSet.remove(2)
    myHashSet.remove(3)
    myHashSet.remove(1)
    LinkedListUtil.printLinkedList(myHashSet.head)

    println(myHashSet.contains(1))
    println(myHashSet.contains(4))
}

class MyHashSet() {

    /** Initialize your data structure here. */
    var head:ListNode? = null


    fun add(key: Int) {
        if (contains(key)) {
            return
        }
        var newNode = ListNode(key)
        var cur = head
        while (cur != null && cur.next != null) {
            cur = cur.next
        }
        if (cur == null) {
            head = newNode
        }else {
            cur.next = newNode
        }
    }

    fun remove(key: Int) {
        var fakeHead = ListNode(0)
        fakeHead.next = head
        var cur:ListNode? = fakeHead
        while (cur != null && cur.next != null) {
            if (cur.next?.`val` == key) {
                cur.next = cur.next?.next
                head = fakeHead.next
                break
            }else {
                cur = cur.next
            }
        }
    }

    /** Returns true if this set contains the specified element */
    fun contains(key: Int): Boolean {
        var cur:ListNode? = head
        while (cur != null) {
            if (cur.`val` == key) {
                return true
            }
            cur = cur.next
        }
        return false
    }

}
