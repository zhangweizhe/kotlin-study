package offer.middle

import kotlin.math.sign

fun main() {
    // 剑指 Offer 46. 把数字翻译成字符串
    // https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
    println(translateNum3(12258))
}

fun translateNum3(num: Int): Int {

    if (num in 0..9) {
        return 1
    }
    if (num in 10..25) {
        return 2
    }
    val numStr = num.toString()
    // dp[i] 表示，以 num[i] 结尾的数的翻译数量
    // 比如对于 2341，dp[0] 表示以2结尾的数的翻译的数量，就是1
    // dp[1] 表示以 num[1]，也就是3结尾的数，也就是23这个数的翻译数量，可以是 23，也可以是 2 3，所以23有两种翻译，也就是 dp[1]=2
    val dp = IntArray(numStr.length)
    dp[0] = 1
    val firstTwo = numStr.substring(0, 2)
    dp[1] = if (firstTwo >= "10" && firstTwo <= "25") {
        2
    }else {
        1
    }
    // 对于以 num[i] 结尾的数的翻译数量 dp[i]，取决于 num[i-1,i+1) 构成的字符串 substring 是否可以合并翻译，如果 "10"<=substring<="25"，则 substring 可以合并翻译，否则则不行
    // 如果 substring 合并翻译，则 dp[i] = dp[i-2]，比如 123 中，23 如果合并翻译，那翻译数量就是 1，也就是 dp[0]；
    // 如果 substring 分开翻译，则 dp[i] = dp[i-1]，比如 123 中，2 3 拆开翻译，那翻译的方法有 (1 2 3)、(12 3) 两种，也就是 dp[1]
    // 所以 dp[i] = dp[i-2]+dp[i-1]（num[i-1, i+1)可以合并翻译）
    // dp[i] = dp[i-1] （num[i-1, i+1)不能合并翻译）
    for (i in 2 until numStr.length) {
        val substring = numStr.substring(i - 1, i + 1)
        if (substring >= "10" && substring <= "25") {
            dp[i] = dp[i-1] + dp[i-2]
        }else {
            dp[i] = dp[i-1]
        }
    }
    return dp[numStr.length-1]
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

fun translateNum2(num: Int): Int {
    if (num in 0..9) {
        return 1
    }
    if (num in 10..25) {
        return 2
    }
    val numStr = num.toString()
    // dp[i] 表示以 num[i-1] 结尾的数的翻译方法数，数组长度 n = numStr.length，要求以 num[n-1] 结尾的数的翻译数量，其实就是求 dp[n]
    val dp = IntArray(numStr.length+1)
    // dp[0]=1，表示以第 1 个数结尾的数的翻译方法数是1
    dp[0] = 1
    // dp[1]，根据前面的if条件，可以知道 num 是大于 25 的，所以以 num[1] 结尾的的数，只有一种翻译方法，就是 num[0]、num[1] 单独翻译
    dp[1] = 1
    for (i in 2..numStr.length) {
        val substring = numStr.substring(i - 2, i)
        if (substring > "10" && substring < "25") {
            // substring 可以合并翻译成一个字母，对应的翻译数量是 dp[i-2]；也可以拆个翻译成两个字母，对应的数量是 dp[i-1]
            dp[i] = dp[i-1] + dp[i-2]
        }else {
            //
            dp[i] = dp[i-1]
        }
    }
    return dp[numStr.length]
}
