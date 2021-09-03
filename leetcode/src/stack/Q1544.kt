package stack

import java.lang.StringBuilder
import java.util.*

fun main() {
    // 1544. 整理字符串
    // https://leetcode-cn.com/problems/make-the-string-great/
    println(makeGood("abBAcC"))
}

fun makeGood(s: String): String {

    val stack = LinkedList<Char>()

    val delta = 'A' - 'a'

    for (c in s) {
        if (stack.isNotEmpty() && (stack.peek() == c + delta || stack.peek() == c - delta)) {
            stack.pop()
        }else {
            stack.push(c)
        }
    }

    val sb = StringBuilder("")
    while (stack.isNotEmpty()) {
        sb.insert(0, stack.pop())
    }

    return sb.toString()
}