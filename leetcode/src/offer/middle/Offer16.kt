package offer.middle

fun main() {
    // 剑指 Offer 16. 数值的整数次方
    // https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
    println(myPow1(2.0, 3))
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

fun myPow1(x: Double, n: Int): Double {
    // 为了方便计算，n如果是负数，就取反，对应的 x 取倒数
    // 如果 n == Int.MIN_VALUE，取反后就越界了，所以 tmpN 声明为 Long 类型
    var tmpN = n.toLong()
    var tmpX = x
    if (tmpN < 0) {
        tmpN = -tmpN
        tmpX = 1/tmpX
    }
    var result = 1.0
    while (tmpN != 0L) {
        if (tmpN % 2 == 1L) {
            result *= tmpX
        }
        tmpX *= tmpX
        tmpN /= 2
    }
    return result
}