package offer.middle

import java.lang.StringBuilder

fun main() {

    println(findNthDigit(1000000000))
}

fun findNthDigit(n: Int): Int {

    var count = 9L // 9 180 2700
    var digit = 1L
    var start = 1L
    var tmpN:Long = n.toLong()
    // 计算 n 位所在的数字的位数digit
    while (tmpN > count) {
        tmpN -= count
        start *= 10
        digit++
        count = digit * start * 9
    }
    // 计算 n 位所在的数字num；举例：start是100，digit是3，tmpN是9，那么 num 是 102
    val num = start + ((tmpN - 1) / digit)
    // 计算 n 位的数字num的第几位
    val remainder = (tmpN - 1) % digit
    val c = num.toString()[remainder.toInt()] - '0'
    return c
}