package offer.middle

fun main() {
    // 剑指 Offer 47. 礼物的最大价值
    // https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
}

fun maxValue(grid: Array<IntArray>): Int {
    /**
     * 关键点：grid[i][j] 的最大值，只能来自于它上边grid[i][j-1] 的元素，或者它左边grid[i-1][j] 的元素
     * 对于首行、首列的元素，上一个礼物最大价值，只能来自于它的左边（首行）、上边（首列）
     */
    val rowCount = grid.size
    val columnCount = grid[0].size
    val dp = Array<IntArray>(rowCount) {
        IntArray(columnCount)
    }

    dp[0][0] = grid[0][0]

    for (i in 0 until rowCount) {
        for (j in 0 until columnCount) {
            if (i == 0 && j == 0) {
                // 左上角第一个元素，不用计算
                continue
            }
            if (i == 0) {
                // 首行的元素，上一个礼物价值总量，只能来自于它左边的元素
                dp[i][j] = dp[i][j-1] + grid[i][j]
                continue
            }
            if (j == 0) {
                // 首列的元素，上一个礼物价值总量，只能来自于它上边的元素
                dp[i][j] += dp[i-1][j] + grid[i][j]
                continue
            }
            // 不是首行，也不是首列，取它左边或者上边中价值量较大的一个
            dp[i][j] = grid[i][j] + Math.max(dp[i][j-1], dp[i-1][j])
        }
    }
    return dp[rowCount-1][columnCount-1]
}

fun maxValue1(grid: Array<IntArray>): Int {
    // 优化版本，使用原来的 grid 数组作为 dp 数组，空间复杂度降到O(1)
    val rowCount = grid.size
    val columnCount = grid[0].size
    for (i in 0 until rowCount) {
        for (j in 0 until columnCount) {
            if (i == 0 && j == 0) {
                // 左上角第一个元素
                continue
            }else if (i == 0) {
                // 首行
                grid[i][j] += grid[i][j-1]
            }else if (j == 0) {
                // 首列
                grid[i][j] += grid[i-1][j]
            }else {
                // 不是首行或首列
                grid[i][j] += Math.max(grid[i][j-1], grid[i-1][j])
            }
        }
    }
    return grid[rowCount-1][columnCount-1]
}