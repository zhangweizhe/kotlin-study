package sort

fun main() {
    // 389. 找不同
    // https://leetcode-cn.com/problems/find-the-difference/

    println(findTheDifference1("aaa", "aaca"))
}

private fun findTheDifference(s: String, t: String): Char {

    var sum = 0

    for (i in s.indices) {
        sum -= s[i].toInt()
        sum += t[i].toInt()
    }

    sum += t[t.length - 1].toInt()

    return sum.toChar()
}

private fun findTheDifference1(s: String, t: String): Char {

    var sum = 0

    for (i in s.indices) {
        sum = sum.xor(s[i].toInt())
        sum = sum.xor(t[i].toInt())
    }

    sum = sum.xor(t[t.length - 1].toInt())

    return sum.toChar()
}