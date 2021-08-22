package string

fun main() {
    // 387. 字符串中的第一个唯一字符
    // https://leetcode-cn.com/problems/first-unique-character-in-a-string/
    println(firstUniqChar("leetcode"))
}

/**
 * 二次遍历法，第一次遍历计算各个字符出现的次数，第二次遍历，找到第一个出现次数为1的字符，并返回下标，
 * 时间复杂度O(n)，n为字符串长度，空间复杂度O(字符集大小)
 */
fun firstUniqChar(s: String): Int {

    val hash = IntArray(26)

    for (c in s) {
        hash[c - 'a']++
    }

    for (i in s.indices) {
        if (hash[s[i] - 'a'] == 1) {
            return i
        }
    }
    return -1
}