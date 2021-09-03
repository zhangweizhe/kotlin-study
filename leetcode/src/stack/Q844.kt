package stack

fun main() {
    // 844. 比较含退格的字符串
    // https://leetcode-cn.com/problems/backspace-string-compare/
    println(backspaceCompare("ab#c", "ad#cd"))
}

fun backspaceCompare(s: String, t: String): Boolean {

    val s1 = help(s)
    val t1 = help(t)
    return s1 == t1
}

private fun help(s: String): String {

    val sb = StringBuilder()
    for (c in s) {
        if (sb.isNotEmpty() && c == '#') {
            sb.deleteCharAt(sb.length - 1)
        }else if (c != '#'){
            sb.append(c)
        }
    }
    return sb.toString()
}