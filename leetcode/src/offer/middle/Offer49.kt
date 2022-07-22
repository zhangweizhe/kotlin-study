package offer.middle

fun main() {
    // 剑指 Offer 49. 丑数
    // https://leetcode.cn/problems/chou-shu-lcof/
    println(nthUglyNumber1(10))
}

fun nthUglyNumber(n: Int): Int {
    // 所有丑数，都可以拆分为 pow(2,x) * pow(3,y) * pow(5,z)
    // 第 n 个丑数，可以由 第 n-1 个丑数 *2 或者 *3 或者 *5 得到
    val dp = IntArray(n)
    // 1 是第一个丑数
    dp[0] = 1
    var p2 = 0
    var p3 = 0
    var p5 = 0
    for (dpIndex in 1 until n) {
        // 取最小的添加到数组最后，而不是直接添加 list[p2]*2, list[p3]*3，list[p5]*5 三个数到最后
        // 因为 list[p2]*2 可能会大于 list[p5]*5
        val min = Math.min(Math.min(dp[p2]*2, dp[p3]*3), dp[p5]*5)
        dp[dpIndex] = min
        if (min == dp[p2]*2) {
            p2++
        }
        if (min == dp[p3]*3) {
            p3++
        }
        if (min == dp[p5]*5) {
            p5++
        }
    }
    return dp[n-1]
}

fun nthUglyNumber1(n: Int): Int {
    // dp[i] 表示第 i 个抽数，比如 dp[1] 表示第 1 个丑数，那么第 n 个丑数，就是 dp[n]
    val dp = IntArray(n+1)
    dp[1] = 1
    // 指向三个序列的指针
    var p2 = 1
    var p3 = 1
    var p5 = 1
    for (i in 2..n) {
        // 从三个序列中，取最小的丑数加入最终的丑数序列中，保证有序
        val min = Math.min(Math.min(dp[p2]*2, dp[p3]*3), dp[p5]*5)
        // 加入最终的丑数序列
        dp[i] = min
        // 用 if...if...if... 去重，而不是 if...else if...else...
        if (min == dp[p2]*2) {
            p2++
        }
        if (min == dp[p3]*3) {
            p3++
        }
        if (min == dp[p5]*5) {
            p5++
        }
    }
    return dp[n]
}