package offer

import java.lang.StringBuilder

fun main() {
    // 剑指 Offer 58 - I. 翻转单词顺序
    // https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
    println(reverseWords1(" a "))
}

fun reverseWords(s: String): String {
    val split = s.split(" ").reversed()
    val sb = StringBuilder()
    for (i in split) {
        if (i != "") {
            sb.append(i).append(" ")
        }
    }
    if (sb.length > 1) {
        sb.deleteCharAt(sb.length - 1)
    }
    return sb.toString()
}
fun reverseWords1(s: String): String {
    // 删除首尾的连续空格
    var i = 0
    while (i < s.length && s[i] == ' ') {
        i++
    }
    var j = s.length - 1
    while (j >= 0 && s[j] == ' ') {
        j--
    }
    if (i > j) {
        return ""
    }
    j++
    val sb = StringBuilder()
    val tmp = s.substring(i, j)
    i = tmp.length - 1
    j = tmp.length - 1
    while (i >= 0) {
        if (tmp[i] == ' ') {
            sb.append(tmp.substring(i+1, j+1)).append(" ")
            while (tmp[i] == ' ') {
                i--
            }
            j = i
        }else if (i == 0){
            sb.append(tmp.substring(i, j+1))
            i--
        }else {
            i--
        }
    }
    return sb.toString()
}