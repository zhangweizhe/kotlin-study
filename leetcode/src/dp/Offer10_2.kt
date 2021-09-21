package dp

import linkedlist.prev

fun main() {
    // 剑指 Offer 10- II. 青蛙跳台阶问题
    // https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
    println(numWays(500))
}

fun numWays(n: Int): Int {

    if (n == 0) {
        return 1
    }
    if (n == 1) {
        return 1
    }

    var p = 1
    var q = 2

    for (i in 3..n) {
        val tmp = (p+q) % 1000000007
        p = q
        q = tmp
    }
    return q
}