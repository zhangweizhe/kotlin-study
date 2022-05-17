package offer.middle

fun main() {
    // 剑指 Offer 04. 二维数组中的查找
    // https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
}

fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {

    if (matrix.size == 0) {
        return false
    }
    var rowIndex = matrix.size - 1
    var columnIndex = 0
    val columnSize = matrix[0].size

    // 从左下角开始找
    // 如果当前元素 == target，返回 true
    // 当前元素 > target，向上找，rowIndex--
    // 当前元素 < target，向右找，columnIndex++
    while (rowIndex >= 0 && columnIndex < columnSize) {
        if (target == matrix[rowIndex][columnIndex]) {
            return true
        }
        if (target < matrix[rowIndex][columnIndex]) {
            rowIndex--
        }else {
            columnIndex++
        }
    }
    return false
}