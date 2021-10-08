package dp

fun main() {
    // 231. 2 的幂
    //  https://leetcode-cn.com/problems/power-of-two/
    println(isPowerOfTwo(16))
}

fun isPowerOfTwo(n: Int): Boolean {
    if (n == 1) {
        return true
    }
    if (n % 2 != 0) {
        return false
    }

    if (n == 2) {
        return true
    }else if (n < 2) {
        return false
    }
    return isPowerOfTwo(n/2)
}

fun isPowerOfTwo1(n: Int): Boolean {
    return n > 0 && n.and(n-1) == 0
}