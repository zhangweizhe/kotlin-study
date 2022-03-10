package dp

/**
 * 01背包问题
 */
fun main() {
    val packageSize = 6
    val objSize = 4
    val weightArray = intArrayOf(2,3,1,5)
    val valueArray = intArrayOf(1,4,2,3)

    val dp = Array<Array<Int>>(objSize + 1) {
        Array<Int>(packageSize + 1) {
            0
        }
    }

    for (i in 1..objSize) {
        for (j in 0..packageSize) {
            val currentValue = valueArray[i-1]
            val currentWeight = weightArray[i-1]
            if (currentWeight > j) {
                // 背包容量放不下当前物品，取上一个物品的价值
                dp[i][j] = dp[i-1][j]
            }else {
                // 背包容量可以放下当前物品
                // 不拿当前物品时的价值，也就是当前容量下上一个物品的价值（最优解）
                val noTakeValue = dp[i-1][j]
                // 拿当前物品时的价值，背包容量减去当前物品重量j-currentWeight，剩余容量的最优解dp[i-1][j-currentWeight]，再加上当前物品的价值currentValue
                val takeValue = dp[i-1][j-currentWeight] + currentValue
                dp[i][j] = Math.max(noTakeValue, takeValue)
            }
        }
    }

    for (i in dp) {
        println(i.contentToString())
    }

    solution2()
}

/**
 * 01 背包问题，一维数组解决
 */
fun solution2() {
    val packageSize = 6
    val objSize = 4
    val weightArray = intArrayOf(2,3,1,5)
    val valueArray = intArrayOf(1,4,2,3)

    val dp = Array<Int>(packageSize + 1) {
        0
    }

    for (i in 1..objSize) {
        val currentWeight = weightArray[i-1]
        val currentValue = valueArray[i-1]

        // 从后往前遍历，因为要用到的 dp[j-currentWeight] 其实是上一轮的值，如果从前往后遍历，dp[j-currentWeight] 会被覆盖
        for (j in packageSize downTo 0) {
            if (currentWeight <= j) {
                dp[j] = Math.max(dp[j], dp[j-currentWeight] + currentValue)
            }
        }
    }

    println(dp.contentToString())
}