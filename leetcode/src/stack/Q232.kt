package stack

import java.util.*

fun main() {
    // 232. 用栈实现队列
    // https://leetcode-cn.com/problems/implement-queue-using-stacks/
}

class MyQueue() {

    private val inStack = Stack<Int>()
    private val outStack = Stack<Int>()


    /** Push element x to the back of queue. */
    fun push(x: Int) {
        inStack.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop())
            }
        }
        return outStack.pop()
    }

    /** Get the front element. */
    fun peek(): Int {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop())
            }
        }
        return outStack.peek()
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return inStack.isEmpty() && outStack.isEmpty()
    }

}