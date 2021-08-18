package array

fun main() {
    // 566. 重塑矩阵
    // https://leetcode-cn.com/problems/reshape-the-matrix/

    println(matrixReshape(arrayOf(intArrayOf(1,2), intArrayOf(3,4)), 1, 3)[0].contentToString())
}

fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {

    if (mat.isEmpty()) {
        return mat
    }
    if (mat.size * mat[0].size != r * c) {
        return mat
    }
    var k = 0
    val result = Array<IntArray>(r) {
        IntArray(c)
    }
    for (i in mat.indices) {
        for (j in mat[i].indices) {
            val rr = k / c
            val cc = k % c
            result[rr][cc] = mat[i][j]
            k++
        }
    }
    return result
}