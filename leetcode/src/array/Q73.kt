package array

fun main() {
    // 73. 矩阵置零
    // https://leetcode-cn.com/problems/set-matrix-zeroes/

    val mat = Array<IntArray>(3) {
        when(it) {
//            0 -> intArrayOf(0,1,2,0)
//            1 -> intArrayOf(3,4,5,2)
//            2 -> intArrayOf(1,3,1,5)
//            else -> intArrayOf()
            0 -> intArrayOf(0)
            1 -> intArrayOf(0)
            2 -> intArrayOf(1)
            else -> intArrayOf()
        }
    }
    setZeroes1(mat)
    for (m in mat) {
        println(m.contentToString())
    }
}

fun setZeroes(matrix: Array<IntArray>): Unit {

    val xy = ArrayList<Pair<Int, Int>>()

    for (row in matrix.indices) {
        for (col in matrix[row].indices) {
            if (matrix[row][col] == 0) {
                xy.add(Pair(row, col))
            }
        }
    }

    val rCount = matrix.size
    val cCount = matrix[0].size
    for (pair in xy) {
        for (x in 1..rCount) {
            matrix[x-1][pair.second] = 0
        }
        for (y in 1..cCount) {
            matrix[pair.first][y-1] = 0
        }
    }
}

/**
 * 用第一行和第一列作为标记数组
 */
fun setZeroes1(matrix: Array<IntArray>): Unit {

    var col0Flag = false
    var row0Flag = false

    val rCount = matrix.size //3
    val cCount = matrix[0].size //4

    for (x in 0 until rCount) {
        if (matrix[x][0] == 0) {
            col0Flag = true
            break
        }
    }

    for (y in 0 until cCount) {
        if (matrix[0][y] == 0) {
            row0Flag = true
            break
        }
    }

    for (x in 0 until rCount) {
        for (y in 0 until cCount) {
            if (matrix[x][y] == 0) {
                matrix[x][0] = 0
                matrix[0][y] = 0
            }
        }
    }

    for (x in 1 until rCount) {
        for (y in 1 until cCount) {
            if (matrix[0][y] == 0) {
                matrix[x][y] = 0
            }
            if (matrix[x][0] == 0) {
                matrix[x][y] = 0
            }
        }
    }

    if (row0Flag) {
        for (y in 0 until cCount) {
            matrix[0][y] = 0
        }
    }

    if (col0Flag) {
        for (x in 0 until rCount) {
            matrix[x][0] = 0
        }
    }
}