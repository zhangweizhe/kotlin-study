package stack

import java.util.*

fun main() {
    // 155. 最小栈
    // https://leetcode-cn.com/problems/min-stack/
    val minStack = MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    println(minStack.getMin());   //--> 返回 -3.
    minStack.pop();
    println(minStack.top());    //  --> 返回 0.
    println(minStack.getMin()); //  --> 返回 -2.

}

class MinStack() {

    /** initialize your data structure here. */
    val valStack = Stack<Int>()
    val minStack = Stack<Int>()

    fun push(x: Int) {
        valStack.push(x)
        if (minStack.isEmpty()) {
            minStack.push(x)
        }else if (minStack.peek() > x){
            minStack.push(x)
        }
    }

    fun pop() {
        val pop = valStack.pop()
        if (pop == minStack.peek()) {
            minStack.pop()
        }
    }

    fun top(): Int {
        return valStack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}

open class ListNode(var `val`:Int) {
    open var next: ListNode? = null

}