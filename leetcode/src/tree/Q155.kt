package tree

fun main() {
    // 155. 最小栈
    // https://leetcode-cn.com/problems/min-stack/
    val minStack = MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    println(minStack.getMin());   //--> 返回 -3.
    minStack.pop();
    minStack.top();    //  --> 返回 0.
    println(minStack.getMin()); //  --> 返回 -2.

}

class MinStack() {

    /** initialize your data structure here. */

    private val head = ListNode(-1)
    private var minVal = Int.MAX_VALUE

    fun push(`val`: Int) {
        val newNode = ListNode(`val`)
        newNode.next = head.next
        head.next = newNode
        if (minVal > `val`) {
            minVal = `val`
        }
    }

    fun pop() {
        if (head.next == null) {
            return
        }
        val popVal = head.next?.`val`
        head.next = head.next?.next
        if (popVal == minVal) {
            minVal = Int.MAX_VALUE
            var cur = head.next
            while (cur != null) {
                if (cur.`val` < minVal) {
                    minVal = cur.`val`
                }
                cur = cur.next
            }
        }
    }

    fun top(): Int {
        if (head.next == null) {
            return 0
        }
        return head.next?.`val`!!
    }

    fun getMin(): Int {
        return minVal
    }

}

open class ListNode(var `val`:Int) {
    open var next:ListNode? = null

}