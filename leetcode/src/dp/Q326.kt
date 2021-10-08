package dp

import kotlin.math.pow

fun main() {
    // 326. 3的幂
    // https://leetcode-cn.com/problems/power-of-three/
    println(isPowerOfThree2(45))
}

fun isPowerOfThree1(n: Int): Boolean {

    var tmp = n
    while (tmp >= 3) {
        if (tmp % 3 != 0) {
            return false
        }
        tmp /= 3
    }
    return tmp == 1
}


fun isPowerOfThree(n: Int): Boolean {

    // 11011
    if (n >= 3) {
        if (n % 3 == 0) {
            return isPowerOfThree(n / 3)
        }else {
            return false
        }
    }

    return n == 1
}


fun isPowerOfThree2(n: Int): Boolean {
    // Int 范围内，最大的3的幂的数为 3的19次方 我们只需要判断 nn 是否是 3^{19}3
    //19
    //  的约数即可。
    return n > 0 && Math.pow(3.0, 19.0).toInt() % n == 0
}