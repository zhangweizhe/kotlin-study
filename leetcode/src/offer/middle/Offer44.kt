package offer.middle

import java.lang.StringBuilder

fun main() {

    println(findNthDigit1(1000000000))
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

fun findNthDigit1(n: Int): Int {
    // 位数
    var digit = 1
    var firstNum = 1
    var digitCount:Long = 9 // 位数数量可能会越界，所以用long
    var tmpN:Long = n - 1L
    // 1、计算 n 位所在的数x是几位数
    while (digitCount < tmpN) {
        tmpN -= digitCount
        digit++
        firstNum *= 10
        digitCount = digit * firstNum * 9L
    }
    // 经过上面的循环，可以得到 n 位所在的数x的位数是 digit
    // 2、计算 n 位所在的数x，具体是哪一个数
    val x = firstNum + (tmpN / digit)
    // 3、计算 n 位在 x 的哪一位上
    return x.toString()[(tmpN%digit).toInt()] - '0'
}