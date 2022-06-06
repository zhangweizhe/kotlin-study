package offer.middle

import java.util.*

fun main() {
    // 剑指 Offer 31. 栈的压入、弹出序列
    // https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/

    println(validateStackSequences(intArrayOf(2,1,0), intArrayOf(1,2,0)))
}

fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {

    val stack = Stack<Int>()
    var popIndex = 0
    for (i in pushed) {
        stack.push(i)
        // 循环判断与出栈
        while (stack.isNotEmpty() && stack.peek() == popped[popIndex]) {
            stack.pop()
            popIndex++
        }
    }
    return stack.isEmpty()
}