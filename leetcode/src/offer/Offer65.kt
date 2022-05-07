package offer

fun main() {
    // 剑指 Offer 65. 不用加减乘除做加法
    // https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
    println(add(2, -4))
}

fun add(a: Int, b: Int): Int {

    // 本位和 = a^b
    var n = a.xor(b)
    // 进位 = a&b << 1
    var c = a.and(b).shl(1)

    // 进位为0时，本位和就是结果，退出循环
    while (c != 0) {
        val tmp = n
        n = n.xor(c)
        c = tmp.and(c).shl(1)
    }
    return n
}