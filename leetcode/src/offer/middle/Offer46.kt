package offer.middle

fun main() {
    // 剑指 Offer 46. 把数字翻译成字符串
    // https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
    println(translateNum1(12258))
}

fun translateNum(num: Int): Int {
    // 参考 https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/
    // 方法一的图解
    // 长度为1时，只有一种翻译方法
    var a = 1
    // 长度为0时，只有一种翻译方法
    var b = 1
    val numString = num.toString()
    for (i in 2..numString.length) {
        val substring = numString.substring(i - 2, i)
        if (substring >= "10" && substring <= "25") {
            // f(i) = f(i-1) + f(i-2) (10<=substring<=25)
            val tmp = a
            a += b
            b = tmp
        }else {
            // f(i) = f(i-1) (
            b = a
        }
    }
    return a
}

fun translateNum1(num: Int): Int {
    if (num < 10) {
        return 1
    }
    if (num in 10..25) {
        return 2
    }
    val numStr = num.toString()
    // 假设 num = x1x2x3x4x5
    // 对于 x1x2x3x4 的翻译数量是 f(4)
    // 对于 x1x2x3 的翻译数量是 f(3)
    // 当 x4x5 作为一个整体翻译时，x1x2x3x4x5 的翻译数量是f(3)
    // 当 单独翻译 x5 时，x1x2x3x4x5 的翻译数量是f(4)
    // 所以当 x4x5 可以作为一个整体翻译时， f(5) = f(3) + f(4);
    // 当 x4x5 不能合并翻译时，只能单独翻译 x5，此时 f(5) = f(4)

    // 状态定义
    // dp[i] 表示以 numStr[i] 结尾的数字的翻译数量
    // 状态转移方程
    // 1）dp[i] = dp[i-2] + dp[i-1]，当 nums[i-2, i) 构成的数字>=10 && <=25
    // 2）dp[i] = dp[i-1]，当 nums[i-2,i) 构成的数字<10 || >25
    val dp = IntArray(numStr.length + 1)
    dp[0] = 1
    dp[1] = 1
    for (i in 2 .. numStr.length) {
        val substring = numStr.substring(i - 2, i)
        if (substring >= "10" && substring <= "25") {
            dp[i] = dp[i-1] + dp[i-2]
        }else {
            dp[i] = dp[i-1]
        }
    }
    return dp[numStr.length]
}