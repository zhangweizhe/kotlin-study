package stack

import java.util.*

fun main() {
    // 20. 有效的括号
    // https://leetcode-cn.com/problems/valid-parentheses/
    println(isValid("()){}[]"))
}

private fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    for (c in s) {
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c)
        }else {
            if (stack.isEmpty()) {
                // 空栈，却遇到了右括号
                return false
            }
            val peek = stack.peek()
            when (c) {
                ')' -> {
                    if (peek != '(') {
                        return false
                    }else {
                        stack.pop();
                    }
                }
                '}' -> {
                    if (peek != '{') {
                        return false
                    }else {
                        stack.pop();
                    }
                }
                ']' -> {
                    if (peek != '['){
                        return false
                    }else {
                        stack.pop();
                    }
                }
            }
        }
    }
    return stack.isEmpty()
}