package string

fun main() {
    // 242. 有效的字母异位词
    // https://leetcode-cn.com/problems/valid-anagram/

    println(isAnagram("tele", "tleeb"))
}

fun isAnagram(s: String, t: String): Boolean {

    if (s.length != t.length) {
        return false
    }

    val bucket = IntArray(26)

    for (i in s.indices) {
        bucket[s[i] - 'a']++
    }

    for (c in t) {
        val i = c - 'a'
        bucket[i]--
        if (bucket[i] < 0) {
            return false
        }
    }

    return true
}