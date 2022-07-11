package offer

import java.lang.StringBuilder
import java.util.*

fun main() {
    // 打印从1到最大的n位数
    println(printNumbers1(6))
}

/**
 * 考虑大数的情况，以字符串的形式返回，1，2，3，4...
 */
fun printNumbers1(n: Int): String {
    if (n == 0) {
        return ""
    }
    val result = StringBuilder()
    val queue = LinkedList<String>()
    // 1..9 入队
    for (i in 1..9) {
        queue.offer("$i")
    }

    // 遍历队列
    while (queue.isNotEmpty()) {
        val poll = queue.poll()
        // append 到结果集合中
        result.append(poll).append(",")
        // 长度小于 n，在 poll 后面补 i，然后入队
        if (poll.length < n) {
            for (i in 0..9) {
                queue.offer("$poll$i")
            }
        }
    }
    return result.toString()
}
