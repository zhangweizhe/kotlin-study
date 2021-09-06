package stack

import java.util.*

fun main() {
    // 682. 棒球比赛
    // https://leetcode-cn.com/problems/baseball-game/
    println(calPoints(arrayOf("5","2","C","D","+")))
}

fun calPoints(ops: Array<String>): Int {

    val stack = Stack<Int>()
    var ret = 0

    for (s in ops) {
        when(s) {
            "C" -> {
                ret -= stack.pop()
            }
            "D" -> {
                ret += stack.peek() * 2
                stack.push(stack.peek() * 2)
            }
            "+" -> {
                val p1 = stack.pop()
                val sum = p1 + stack.peek()
                stack.push(p1)
                stack.push(sum)
                ret += sum
            }
            else -> {
                stack.push(s.toInt())
                ret += s.toInt()
            }
        }
    }
    return ret
}