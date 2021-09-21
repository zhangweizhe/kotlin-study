package dp

fun main() {
    // 剑指 Offer 10- I. 斐波那契数列
    // https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
    println(fib(6))
}

private fun fib(n: Int): Int {

    if (n == 0) {
        return 0
    }
    if (n == 1) {
        return 1
    }
    var p = 0
    var q = 1
    var r = 1

    var i = 2
    while (i < n) {
        p = q
        q = r
        r = (q + p) % 1000000007
        i++
    }
    return r
}