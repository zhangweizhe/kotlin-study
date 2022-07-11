package offer.middle

fun main() {
    // 剑指 Offer 63. 股票的最大利润
    // https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/
    println(maxProfit1(intArrayOf(7,1,5,3,6,4)))
}

fun maxProfit(prices: IntArray): Int {
    if (prices.isEmpty()) {
        return 0
    }
    // 1、状态定义：dp[i] 表示前 i 天的最大利润
    // 2、转移方程：前 i 天的最大利润dp[i]，取前 i-1 天的最大利润dp[i-1] 和 第 i 天卖出的最大利润，两者中的最大值
    // dp[i] = max(dp[i-1], prices[i]-min[0:i])，min[0:i] 表示前 i 天的最小值
    // 3、初始状态：dp[0] = 0，表示首日的利润为0
    // 4、返回值：dp[dp.size-1]
    val dp = IntArray(prices.size)
    var min = prices[0]
    dp[0] = 0
    for (i in 1 until prices.size) {
        if (prices[i] < min) {
            min = prices[i]
        }
        dp[i] = Math.max(dp[i-1], prices[i] - min)
    }
    return dp[dp.size-1]
}

fun maxProfit1(prices: IntArray): Int {
    // 动态规划，空间优化版本
    // 因为 dp[i] 只和 dp[i-1] 有关，所以用 pre 代替 dp[i-1]，
    if (prices.isEmpty()) {
        return 0
    }
    var pre = 0
    var min = prices[0]
    for (i in 1 until prices.size) {
        if (prices[i] < min) {
            min = prices[i]
        }
        pre = Math.max(pre, prices[i] - min)
    }
    return pre
}