package string

fun main() {
    // 剑指 Offer 05. 替换空格
    // https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
    println(replaceSpace("We are happy."))
}

fun replaceSpace(s: String): String {

    val sb = StringBuilder()
    for (c in s) {
        if (c == ' ') {
            sb.append("%20")
        }else {
            sb.append(c)
        }
    }
    return sb.toString()
}