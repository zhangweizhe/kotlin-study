package offer.middle

fun main() {
    // 剑指 Offer 14- II. 剪绳子 II
    // https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/
    println(cuttingRope(120))
}

private fun cuttingRope(n: Int): Int {
    if (n == 2) {
        return 1
    }
    if (n == 3) {
        return 2
    }
    // 下面代码只处理 n 大于 3 的场景
    // 每段长度为3时，乘积最大
    val ropeNums = n / 3
    val remain = n % 3
    var result = 1L
    val p = 1000000007L
    for (i in 1 until  ropeNums) {
        println(result*3)
        result = (result * 3) % p
    }
    when(remain) {
        0 -> result = result * 3 % p
        1 -> result = result * 4 % p
        2 -> result = result * remain % p
    }
    return result.toInt()
}