package offer

import java.util.*

fun main() {

    println(isPalindrome1("A man, a plan, a canal: Panama"))
    println(isPalindrome1("race a car"))
    println(isPalindrome1(" "))
}


/**
 * https://leetcode-cn.com/problems/XltzEq/
 * 剑指 Offer II 018. 有效的回文
 */
fun isPalindrome(s: String): Boolean {
    if (s.isEmpty()) {
        return true
    }
    var left = 0
    var right = s.length-1
    while (left < right) {
        while (!isNum(s[left]) && left < right) {
            left++
        }
        while (!isNum(s[right]) && left < right) {
            right--
        }
        if (s[left].toLowerCase() != s[right].toLowerCase()) {
            return false
        }
        left++
        right--
    }
    return true
}

private fun isNum(char: Char):Boolean {
    return (char in 'a'..'z') || (char in 'A'..'Z') || (char in '0'..'9')
}

fun isPalindrome1(s: String): Boolean {

    val stack = Stack<Char>()

    for (c in s) {
        if (!isNum(c)) {
            continue
        }
        if (stack.isNotEmpty() && c.equals(stack.peek(), ignoreCase = true)) {
            stack.pop()
        }else {
            stack.push(c)
        }
    }
    return stack.isEmpty()
}