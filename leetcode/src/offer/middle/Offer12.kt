package offer.middle

fun main() {
    // 剑指 Offer 12. 矩阵中的路径
    // https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/
    val ca1 = charArrayOf('A', 'B', 'C', 'E')
    val ca2 = charArrayOf('S', 'F', 'C', 'S')
    val ca3 = charArrayOf('A', 'D', 'E', 'E')
    val board = Array<CharArray>(3) {
        when(it) {
            0 -> ca1
            1 -> ca2
            2 -> ca3
            else -> charArrayOf()
        }
    }
    println(exist(board, "ABCCED"))
}

fun exist(board: Array<CharArray>, word: String): Boolean {
    if (board.isEmpty()) {
        return word.isEmpty()
    }
    val rowCount = board.size
    val columnCount = board[0].size

    for (i in 0 until rowCount) {
        for (j in 0 until columnCount) {
            if (help(board, rowCount, columnCount, i, j, word, 0)) {
                return true
            }
        }
    }
    return false
}

private fun help(board: Array<CharArray>, rowCount: Int, columnCount: Int, i: Int, j: Int, word: String, wordIndex: Int): Boolean {
    if (wordIndex == word.length) {
        return true
    }
    if (i < 0 || i >= rowCount) {
        return false
    }
    if (j < 0 || j >= columnCount) {
        return false
    }
    if (word[wordIndex] == board[i][j]) {
        // 往上下左右四个方向找下个字符
        // 注意先把当前字符置为空格，表示已经遍历过了
        board[i][j] = ' ' //
        val b = (help(board, rowCount, columnCount, i, j - 1, word, wordIndex + 1)
                || help(board, rowCount, columnCount, i - 1, j, word, wordIndex + 1)
                || help(board, rowCount, columnCount, i, j + 1, word, wordIndex + 1)
                || help(board, rowCount, columnCount, i + 1, j, word, wordIndex + 1))
        // 四个方向查找完了，再被当前字符恢复
        board[i][j] = word[wordIndex]
        return b
    }
    return false
}