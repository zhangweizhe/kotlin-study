package stack

class Q1441 {
}

fun main() {
    // 1441. 用栈操作构建数组
    // https://leetcode-cn.com/problems/build-an-array-with-stack-operations/
    println(buildArray(intArrayOf(1,2), 4))
}

fun buildArray(target: IntArray, n: Int): List<String> {

    val ret = ArrayList<String>()

    var ti = 0

    for (i in 1..n) {
        if (ti >= target.size) {
            break
        }
        ret.add("Push")
        if (i == target[ti]) {
            ti++
        }else {
            ret.add("Pop")
        }
    }
    return ret
}