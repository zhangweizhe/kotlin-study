package array

fun main() {
    // 36. 有效的数独
    // https://leetcode-cn.com/problems/valid-sudoku/

}

fun isValidSudoku(board: Array<CharArray>): Boolean {

    val rowMap = Array(9) {
        IntArray(9)
    }
    val colMap = Array(9) {
        IntArray(9)
    }
    val boxMap = Array(9) {
        IntArray(9)
    }

    for (row in 0..8) {
        for (col in 0..8) {
            val c = board[row][col]
            if (!c.isDigit()) {
                continue
            }
            val index = c - '1'
            val boxIndex:Int = (row / 3) * 3 + col / 3
            when {
                rowMap[row][index] == 1 -> {
                    return false
                }
                colMap[col][index] == 1 -> {
                    return false
                }
                boxMap[boxIndex][index] == 1 -> {
                    return false
                }
                else -> {
                    rowMap[row][index] = 1
                    colMap[col][index] = 1
                    boxMap[boxIndex][index] = 1
                }
            }
        }
    }

    return true
}