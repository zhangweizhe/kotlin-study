fun main() {
    // 剑指 Offer 62. 圆圈中最后剩下的数字
    val solution = Solution()
    println(solution.lastRemaining(5,3))
}

class Solution {

    fun lastRemaining(n: Int, m: Int): Int {
        var ans = 0
        for (i in 2..n) {
            ans = (ans + m) % i
        }
        return ans
    }

}
