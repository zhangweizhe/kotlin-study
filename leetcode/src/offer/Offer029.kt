package offer

import kotlin.math.sign

fun main() {
    // 剑指 Offer 29. 顺时针打印矩阵
    // https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/

    val r1 = intArrayOf(1,2,3,4)
    val r2 = intArrayOf(5,6,7,8)
    val r3 = intArrayOf(9,10,11,12)
    val matrix = Array<IntArray>(3) {
        when(it) {
            0 -> r1
            1 -> r2
            2 -> r3
            else -> IntArray(3)
        }
    }

    println(spiralOrder(matrix).contentToString())

}

private fun spiralOrder(matrix: Array<IntArray>): IntArray {

    val rows = matrix.size

    if (rows == 0) {
        return IntArray(0)
    }
    val columns = matrix[0].size

    var toRight = true
    var toBottom = false
    var toLeft = false
    var toTop = false

    val total = rows * columns

    // 四个方向的边界，遍历过程中逐步向中心靠近
    var leftIndex = 0
    var rightIndex = columns - 1
    var topIndex = 0
    var bottomIndex = rows - 1

    val res = IntArray(total)

    var i = 0
    while (i < total) {
        if (toRight && i < total) {
            for (c in leftIndex .. rightIndex) {
                // 0,0  0,1  0,2  0,3 ...
                res[i] = matrix[topIndex][c]
                i++
            }
            topIndex++
            toRight = false
            toBottom = true
        }
        if (toBottom && i < total) {
            // 1,3  2,3  3,3 ...
            for (r in topIndex .. bottomIndex) {
                res[i] = matrix[r][rightIndex]
                i++
            }
            rightIndex--
            toBottom = false
            toLeft = true
        }
        if (toLeft && i < total) {
            for (c in rightIndex downTo leftIndex) {
                res[i] = matrix[bottomIndex][c]
                i++
            }
            bottomIndex--
            toLeft = false
            toTop = true
        }
        if (toTop && i < total) {
            for (r in bottomIndex downTo topIndex) {
                res[i] = matrix[r][leftIndex]
                i++
            }
            leftIndex++
            toRight = true
            toTop = false
        }
    }

    return res
}