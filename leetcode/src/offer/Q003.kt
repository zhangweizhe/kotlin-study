package offer

fun main() {
    // 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
    // https://leetcode-cn.com/problems/w3tCBm/
    println(countBits1(5).contentToString())

}

fun countBits(n: Int): IntArray {

    val ret = IntArray(n+1)

    for (i in 0..n) {
        var tmp = i
        var count = 0
        while (tmp != 0) {
            if ((tmp and 1) == 1) {
                count++
            }
            tmp = tmp.shr(1)
        }
        ret[i] = count
    }

    return ret
}

fun countBits1(n: Int): IntArray {

    val ret = IntArray(n+1)
    var highBit = 0

    for (i in 1..n) {
        if (i.and(i-1) == 0) {
            // i & (i-1) == 0，表示 i 的最高位是1，其他位都是0，即 i 是 2 的整数次幂
            highBit = i
        }
        ret[i] = ret[i - highBit] + 1
    }

    return ret
}