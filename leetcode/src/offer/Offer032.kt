package offer

fun main() {
    // https://leetcode-cn.com/problems/dKk3P7/
    // 剑指 Offer II 032. 有效的变位词
    println(isAnagram("rat", "car"))
}

fun isAnagram(s: String, t: String): Boolean {

    if (s == t) {
        return false
    }

    var buck = IntArray(26)

    for (c in s) {
        buck[c-'a']++
    }
    for (c in t) {
        buck[c-'a']--
    }
    for (i in buck) {
        if (i != 0) {
            return false
        }
    }
    return true
}