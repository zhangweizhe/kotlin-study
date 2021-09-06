package stack

import java.util.*

fun main() {
    // 剑指 Offer 30. 包含min函数的栈
    // https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
}

class MinStack2() {

    /** initialize your data structure here. */

    val valStack = Stack<Int>()
    val minStack = Stack<Int>()

    fun push(x: Int) {
        valStack.push(x)
        if (minStack.isEmpty()) {
            minStack.push(x)
        }else {
            minStack.push(Math.min(minStack.peek(), x))
        }
    }

    fun pop() {
        valStack.pop()
        minStack.pop()
    }

    fun top(): Int {
        return valStack.peek()
    }

    fun min(): Int {
        return minStack.peek()
    }

}
