fun main() {
    // https://leetcode-cn.com/problems/implement-strstr/

    println(strStr1("hello", "l"))
}

fun strStr(haystack: String, needle: String): Int {
    var left = 0
    var right = left + needle.length

    while (right <= haystack.length) {
        if (needle == haystack.substring(left, right)) {
            return left
        }else{
            left++
            right++
        }
    }
    return -1
}

/**
 * 暴力解法，让 needle 与字符串 haystack 所有长度为 m 的子串都匹配一遍
 */
fun strStr1(haystack: String, needle: String): Int {
    var n = haystack.length
    var m =  needle.length
    var i = 0
    while (i + m <= n) {
        var j = 0
        var found = true
        while (j < m) {
            if (needle[j] == haystack[i+j]) {
                j++
            }else{
                found = false
                break
            }
        }
        if (found) {
            return i
        }else{
            i++
        }
    }
    return -1
}