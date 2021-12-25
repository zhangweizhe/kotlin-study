package offer

fun main() {
    // 剑指 Offer II 088. 爬楼梯的最少成本
    // https://leetcode-cn.com/problems/GzCJIP/

    println(minCostClimbingStairs(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)))
}

private fun minCostClimbingStairs(cost: IntArray): Int {

    val dp = IntArray(cost.size + 1)

    dp[0] = 0
    dp[1] = 0

    for (i in 2..cost.size) {
        dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
    }

    return dp[cost.size]
}