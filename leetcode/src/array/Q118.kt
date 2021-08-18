package array

fun main() {
    // 118. 杨辉三角
    // https://leetcode-cn.com/problems/pascals-triangle/
    println(generate(5))
}

fun mat() {

}

private fun generate(numRows: Int): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    for (i in 1..numRows) {
        val list = ArrayList<Int>(i)
        var j = 0
        while (j < i) {
            if (j == 0 || j == i - 1) {
                list.add(1)
            }else {
                val sum = result[i - 2][j - 1] + result[i - 2][j]
                list.add(sum)
            }
            j++
        }
        result.add(list)
    }
    return result
}