package stack

import java.util.*

fun main() {
    // 225. 用队列实现栈
    // https://leetcode-cn.com/problems/implement-stack-using-queues/
    val myStack = MyStack()
    myStack.push(1);
    myStack.push(2);
    println(myStack.top()); // 返回 2
    println(myStack.pop()); // 返回 2
    println(myStack.empty()); // 返回 False

}

class MyStack() {

    /** Initialize your data structure here. */
    var inQueue:Queue<Int> = LinkedList()

    /** Push element x onto stack. */
    fun push(x: Int) {
        inQueue.offer(x)
        val size = inQueue.size
        for (i in 1 until size) {
            inQueue.offer(inQueue.poll())
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        return inQueue.poll()
    }

    /** Get the top element. */
    fun top(): Int {
        return inQueue.peek()
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return inQueue.isEmpty()
    }

}