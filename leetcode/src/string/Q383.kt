package string

fun main() {
    // 383. 赎金信
    // https://leetcode-cn.com/problems/ransom-note/
    println(canConstruct("aa", "ab"))
}

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val bucket = IntArray(26)

    for (c in magazine) {
        bucket[c - 'a']++
    }

    for (c in ransomNote) {
        if (bucket[c - 'a'] <= 0) {
            return false
        }
        bucket[c - 'a']--
    }

    return true
}