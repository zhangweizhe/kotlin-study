package dp

fun main() {
    // 509. 斐波那契数
    // https://leetcode-cn.com/problems/fibonacci-number/
    println(fib(4))
}

private fun fib(n: Int): Int {

    if (n == 1) {
        return 1
    }
    if (n == 0) {
        return 0
    }

    var p = 0
    var q = 1
    var ret = 1
    var i = n
    while (i in 3..n) {
        p = q
        q = ret
        ret = p + q
        i--
    }
    return ret
}