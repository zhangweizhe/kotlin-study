package offer.middle

fun main() {
    // 剑指 Offer 67. 把字符串转换成整数
    // https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
    println(strToInt("-91283472332"))
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