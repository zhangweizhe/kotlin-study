package offer.middle

fun main() {
    // 剑指 Offer 14- I. 剪绳子
    // https://leetcode.cn/problems/jian-sheng-zi-lcof/
    for (i in 2..10) {
        println("$i -> ${cuttingRope1(i)}")
    }
}

private fun cuttingRope(n: Int): Int {

    /**
     * 如果是剪 1 刀，那么可以剪出的长度是 1、2、3...n-1
     * 则剩下的长度是 n-1、n-2、n-3...1
     * 一共有 n-1 种剪法
     * 即剪下的长度为j，剩下的长度为 n-j
     * 剩下的长度 n-j 可以剪，也可以不剪
     * 剪：n-j 的最优解是 f(n-j)
     * 不剪：n-j 的最优解就是 n-j
     * 那么 f(n) = j * max(f(n-j), n-j) j属于[2,n]
     * */

    val dp = IntArray(n+1)
    dp[1] = 1
    dp[2] = 1
    // 绳子长度从 2 到 n
    for (i in 2..n) {
        // 剪下一段的长度1 到 i-1
        for (j in 1 until i) {
            // 剪掉的长度是j，剩下的长度是 i-j
            // 那么剩下的 i-j 的最优解就是  1）不剪：i-j；2）剪：dp[i-j]；所以取两者的最大值
            // 然后乘以 j，就是绳子长度为i，剪下长度为 j 的最优解
            val tmp = j * Math.max(dp[i-j], i-j)
            // 比较每个 j 的最优解，取最大的那个
            dp[i] = Math.max(tmp, dp[i])
        }
    }
    println(dp.contentToString())
    return dp[n]
}

fun cuttingRope1(n: Int): Int {
    val dp = IntArray(n+1)
    dp[2] = 1
    for (i in 2..n) {
        for (j in 1 until i) {
            val tmp = j * Math.max(dp[i-j], i-j)
            dp[i] = Math.max(tmp, dp[i])
        }
    }
    return dp[n]
}

fun cuttingRope2(n: Int): Int {
    /**
     * 绳子长度是 n
     * 假设剪一刀，那么剪掉的长度可以是 1、2、3、4...n-1，
     * 剩下的长度，就是 n-1, n-2, n-3 ... 1
     * 即剪下的长度是j，剩下的长度是 n-j
     * 共有 n-1 种剪法
     * 定义 f(n) 表示长度为 n 的长度的最优解
     * 对于剩下的 n-j，我们可以选择剪，或者不剪，
     * 剪：那么剩下的长度 n-j 的最优解是 f(n-j)
     * 不剪：那么 n-j 就是最优解
     * 则 f(n) = j * Max(f(n-j), n-j)
     */

    val dp = IntArray(n+1);
    // 绳子长度为2时，最优解是1
    dp[2] = 1
    // 绳子长度 [2,n]
    for (i in 2..n) {
        // 剪掉的长度
        for (j in 1 until i) {
            val tmp = j * Math.max(dp[i-j], i-j);
            dp[i] = Math.max(tmp, dp[i]);
        }
    }
    return dp[n];
}