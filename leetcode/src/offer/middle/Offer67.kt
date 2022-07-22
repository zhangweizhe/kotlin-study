package offer.middle

fun main() {
    // 剑指 Offer 67. 把字符串转换成整数
    // https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
    println(strToInt1("42"))
}

fun strToInt(str: String): Int {

    var result = 0
    var index = 0
    // 边界
    val boundary = Int.MAX_VALUE / 10
    while (index < str.length) {
        if (str[index] == ' ') {
            index++
        }else {
            break
        }
    }
    if (index == str.length) {
        // 都是空格字符
        return 0
    }
    var sign = 1
    if (str[index] == '-') {
        sign = -1
        index++
    }else if (str[index] == '+') {
        index++
    }
    while (index < str.length) {
        val curChar = str[index]
        if (curChar < '0' || curChar > '9') {
            break
        }
        // 将要越界的条件
        // 1）result > boundary，那么 result * 10 后一定越界
        // 2）result == boundary，result * 10 后不会越界，但是需要关注下一个字符的值，如果是大于 7，那就会越界
        if (result > boundary || (result == boundary && curChar > '7')) {
            return if (sign == 1) {
                Int.MAX_VALUE
            }else {
                Int.MIN_VALUE
            }
        }
        result = result * 10 + (curChar - '0')
        index++
    }
    return sign * result
}

fun strToInt1(str: String): Int {
    var i = 0

    // 找到第一个不是空格的字符串
    while (i < str.length) {
        if (str[i] != ' ') {
            break
        }
        i++
    }
    // 判断正负号
    var positive = true
    if (i < str.length) {
        if (str[i] == '-') {
            positive = false
            i++
        }else if (str[i] == '+') {
            i++
        }
    }
    var result = 0
    val left = Int.MIN_VALUE / 10 // 左边界
    val right = Int.MAX_VALUE / 10 // 右边界
    // 遍历剩余的字符串
    while (i < str.length) {
        val c = str[i]
        if (c in '0'..'9') {
            // 遍历到的字符是数字
            val num = c - '0'
            if (!positive) {
                // 负数
                // 判断是否将要越过 Int.MIN
                if (result < left || (result == left && num > 8)) {
                    // result < left，那么 result*10 之后，将会越过 Int.MIN，所以直接返回Int.MIN
                    // result == left && num>8，那么 result*10 - num，也将越过 Int.MIN
                    return Int.MIN_VALUE
                }else {
                    // 没有越界
                    result = result * 10 - num
                }
            }else {
                // 正数
                // 判断是否将要越过 Int.MAX
                if (result > right || (result == right && num > 7)) {
                    return Int.MAX_VALUE
                }else {
                    result = result * 10 + num
                }
            }
            i++
        }else {
            break
        }
    }
    return result
}