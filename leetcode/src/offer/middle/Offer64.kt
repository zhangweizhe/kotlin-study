package offer.middle

fun main() {
    // 剑指 Offer 64. 求1+2+…+n
    // https://leetcode.cn/problems/qiu-12n-lcof/
    val offer64 = Offer64()
    println(offer64.sumNums(3))

}

private class Offer64 {
    var res = 0
    fun sumNums(n: Int): Int {
        // sumNums(n-1) > 0 条件是否成立并不重要，只是为了把 sumNums(n-1) 放在 && 后面，
        // 所以大于0 小于0 等于0 都可以
        // n是要大于1的，这样当等于1时，才会短路后面的 sumNums(n-1)
        n > 1 && sumNums(n-1) > 0
        res += n
        return res
    }
}