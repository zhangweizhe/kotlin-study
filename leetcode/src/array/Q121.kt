package array

fun main() {
    // 121. 买卖股票的最佳时机
    // https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
    println(maxProfit(intArrayOf(7,1,5,3,6,4)))
}

fun maxProfit(prices: IntArray): Int {
    if (prices.isEmpty()) {
        return 0
    }
    var minPrice = Int.MAX_VALUE
    var maxProfit = Int.MIN_VALUE
    for (i in prices) {
        if (i < minPrice) {
            minPrice = i
        }else {
            val delta = i - minPrice
            if (delta > maxProfit) {
                maxProfit = delta
            }
        }
    }
    if (maxProfit == Int.MIN_VALUE) {
        maxProfit = 0
    }
    return maxProfit
}