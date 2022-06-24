package offer.middle

fun main() {
    val i:Int
    i=30
    println(i)
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
            // 遍历矩阵中的每个元素，对每个元素执行递归，如果其中一个满足条件，就返回
            if (help(board, rowCount, columnCount, i, j, word, 0)) {
                return true
            }
        }
    }
    return false
}

private fun help(board: Array<CharArray>, rowCount: Int, columnCount: Int, i: Int, j: Int, word: String, wordIndex: Int): Boolean {
    if (wordIndex == word.length) {
        // 找到了满足条件的路径，返回 true
        return true
    }
    if (i < 0 || i >= rowCount) {
        // 水平方向越界，返回 false
        return false
    }
    if (j < 0 || j >= columnCount) {
        // 竖直方向越界，返回 false
        return false
    }
    if (word[wordIndex] == board[i][j]) {
        // 遍历到的元素 == word[wordIndex]，递归判断上下左右的四个元素是否 == word[wordIndex + 1]
        // 先把当前元素置为特殊字符，避免递归过程中往回找
        board[i][j] = '0'
        val b = (help(board, rowCount, columnCount, i, j - 1, word, wordIndex + 1)
                || help(board, rowCount, columnCount, i - 1, j, word, wordIndex + 1)
                || help(board, rowCount, columnCount, i, j + 1, word, wordIndex + 1)
                || help(board, rowCount, columnCount, i + 1, j, word, wordIndex + 1))
        // 递归结束，恢复该字符
        board[i][j] = word[wordIndex]
        return b
    }
    return false
}