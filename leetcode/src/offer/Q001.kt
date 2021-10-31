package offer

fun main() {
    // 剑指 Offer II 001. 整数除法
    // https://leetcode-cn.com/problems/xoh6Oh/
    println(divide(Int.MAX_VALUE, Int.MIN_VALUE))
    println(divide1(Int.MAX_VALUE, Int.MIN_VALUE))
}

private fun divide(a: Int, b: Int): Int {

    if (a == Int.MIN_VALUE && b == -1) {
        // MIN_VALUE = -2147483648
        // MAX_VALUE = 2147483647
        // MIN_VALUE / (-1) = 2147483648 > 2147483647 越界
        return Int.MAX_VALUE
    }

    val sign = if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
        -1
    }else {
        1
    }

    // MIN_VALUE 转成正数会越界，MAX_VALUE 转成负数不会越界，
    // 而只要 a b 同为正数或负数，则结果是一样，所以将两个数同时转为负数
    var tmpA = if (a > 0) {
        -a
    }else {
        a
    }
    val tmpB = if (b > 0) {
        -b
    }else {
        b
    }
    var count = 0
    while (tmpA <= tmpB) {
        var value = tmpB
        var k = 1
        /**
         * 0xc0000000 是二进制 -2^30 次方的十六进制表示
         * tmpB >= 0xc0000000 这个判断是为了保证 tmpB + tmpB 不会越界，即 tmpB + tmpB 不小于 Int.MIN_VALUE
         */
        while (tmpB >= 0xc0000000 && tmpA < tmpB + tmpB) {
            value.shl(2)
            k.shl(2)
        }
        tmpA -= (value)
        count += k
    }

    return sign * count
}


private fun divide1(a: Int, b: Int): Int {

    if (a == Int.MIN_VALUE && b == -1) {
        // MIN_VALUE = -2147483648
        // MAX_VALUE = 2147483647
        // MIN_VALUE / (-1) = 2147483648 > 2147483647 越界
        return Int.MAX_VALUE
    }

    val sign = if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
        -1
    }else {
        1
    }

    var tmpA = Math.abs(a)
    var tmpB = Math.abs(b)

    var count = 0

    for (i in 31 downTo 0) {
        /**
         * tmpA >= (tmpB << i)，(tmpB << 1) 存在越界的可能；
         * 所以改成 (tmpA >> i) >= tmpB，再怎么右移，都不会越界；
         * 如果 a == Int.MIN_VALUE(-2147483648)，则 tmpA = Math.abs(-2147483648) == -2147483648，
         * 所以要采用无符号位移，把 -2147483648 看成 2147483648；
         * 所以改为 (tmpA >>> i) >= tmpB；
         * 如果 tmpB == Int.MIN_VALUE，则 (tmpA >>> i) >= tmpB 永远为 true；
         * 所以改成 (tmpA >>> i) - tmpB >= 0，这个表达式可能为 false
         */
        if (tmpA.ushr(i) - tmpB >= 0) {// tmpA >= (tmpB <<< i)
            tmpA -= tmpB.shl(i)
            count += (1 .shl(i))
        }
    }

    return if (sign == -1) {
        -count
    }else {
        count
    }
}