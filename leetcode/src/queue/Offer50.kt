package queue

import kotlin.math.min

fun main() {
    // 剑指 Offer 50. 第一个只出现一次的字符
    // https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
    println(firstUniqChar("abaccdeff"))
}

fun firstUniqChar(s: String): Char {

    // 字符和索引的映射，如果出现次数大于1，则将value置为-1
    val charIndexMap = HashMap<Char, Int>(s.length)

    for ((i, c) in s.withIndex()) {
        if (charIndexMap.containsKey(c)) {
            charIndexMap[c] = -1
        }else {
            charIndexMap[c] = i
        }
    }

    var minIndex = s.length
    for (i in charIndexMap) {
        if (i.value != -1 && minIndex > i.value) {
            minIndex = i.value
        }
    }
    if (minIndex == s.length) {
        return ' '
    }
    return s[minIndex]
}