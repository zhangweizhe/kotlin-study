package offer.middle

fun main() {
    // 剑指 Offer 46. 把数字翻译成字符串
    // https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
    println(translateNum(12258))
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