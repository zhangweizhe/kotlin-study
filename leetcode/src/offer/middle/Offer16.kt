package offer.middle

fun main() {
    // 剑指 Offer 16. 数值的整数次方
    // https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
    println(myPow(2.0, Int.MIN_VALUE))
}

fun myPow(x: Double, n: Int): Double {
    // x=3, n=5
    var tmp:Long = n.toLong() //tmp=5
    var ret = 1.0 //3
    var tmpX = x

    if (tmp < 0) {
        tmpX = 1/tmpX
        tmp = -tmp
    }
    while (tmp > 0) {
        if (tmp % 2 == 1L) {
            ret *= tmpX
        }
        tmpX *= tmpX
        tmp /= 2
    }
    return ret
}