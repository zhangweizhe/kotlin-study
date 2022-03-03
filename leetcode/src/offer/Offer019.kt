package offer

fun main() {
    // https://leetcode-cn.com/problems/RQku0D/
    // 剑指 Offer II 019. 最多删除一个字符得到回文
    println(validPalindrome("deeee"))
}

fun validPalindrome(s: String): Boolean {

    var left = 0
    var right = s.length - 1

    while (left < right) {
        if (s[left] == s[right]) {
            left++
            right--
            continue
        }else {
            break
        }
    }
    var tmpRight = right
    var tmpLeft = left
    // 左边删除一个
    left++
    while (left < right) {
        if (s[left] == s[right]) {
            left++
            right--
            continue
        }else {
            break
        }
    }
    // 左边删除一个，形成回文
    if (left >= right) {
        return true
    }

    // 右边删除一个
    tmpRight--
    while (tmpLeft < tmpRight) {
        if (s[tmpLeft] == s[tmpRight]) {
            tmpLeft++
            tmpRight--
            continue
        }else {
            return false
        }
    }
    return true
}