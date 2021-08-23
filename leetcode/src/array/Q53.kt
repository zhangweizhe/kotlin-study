package array

import kotlin.math.max

fun main() {
    // 53. 最大子序和
    // https://leetcode-cn.com/problems/maximum-subarray/
}

fun maxSubArray(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }

    val dp = IntArray(nums.size)
    dp[0] = nums[0]

    var i = 1
    var result = dp[0]
    while (i < nums.size) {
        dp[i] = Math.max(dp[i-1] + nums[i], nums[i])
        result = Math.max(result, dp[i])
        i++
    }
    return result
}