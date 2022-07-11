package offer

fun main() {
    // 剑指 Offer 62. 圆圈中最后剩下的数字
    // https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
    println(lastRemaining(5,3))
}

fun lastRemaining(n: Int, m: Int): Int {

    var ans = 0
    for (i in 2..n) {
        ans = (ans + m) % i
    }
    return ans
}