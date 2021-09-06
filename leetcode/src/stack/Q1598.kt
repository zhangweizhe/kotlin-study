package stack

fun main() {
    // 1598. 文件夹操作日志搜集器
    // https://leetcode-cn.com/problems/crawler-log-folder/
    println(minOperations(arrayOf("d1/","d2/","../","d21/","./")))
}

fun minOperations(logs: Array<String>): Int {

    var ret = 0
    for (s in logs) {
        when(s) {
            "../" -> {
                if (ret > 0) {
                    ret--
                }
            }
            "./"->{}
            else -> ret++
        }
    }
    return ret
}