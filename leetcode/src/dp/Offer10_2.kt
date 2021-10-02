package dp

import linkedlist.prev

fun main() {
    // 剑指 Offer 10- II. 青蛙跳台阶问题
    // https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
    println(numWays(500))
}

fun numWays1(n: Int): Int {

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


fun numWays(n: Int): Int {
    val map = HashMap<Int, Int>(n)
    return help(map, n)
}

fun help(map:MutableMap<Int, Int>, n: Int): Int {
    if (n == 0 || n == 1) {
        return 1
    }
    val n1 = if (map.containsKey(n-1)) {
        map[n-1]
    }else {
        val help = help(map, n - 1)
        help
    } ?: 0

    val n2 = if (map.containsKey(n-2)) {
        map[n-2]
    }else {
        val help = help(map, n-2)
        help
    } ?: 0
    val ret = (n1 + n2) % 1000000007
    map[n] = ret

    return ret
}