package bytedance;

public class Q79 {
    public static void main(String[] args) {
        // 79. 单词搜索
        // https://leetcode.cn/problems/word-search/
    }

    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (find(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, String word, int wordIndex, int i, int j) {
        if (wordIndex == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length) {
            return false;
        }
        if (j < 0 || j >= board[0].length) {
            return false;
        }
        char c = word.charAt(wordIndex);
        if (c == board[i][j]) {
            // 避免重复使用
            board[i][j] = ' ';
            boolean result = find(board, word, wordIndex+1, i-1, j) ||
                    find(board, word, wordIndex+1, i, j-1) ||
                    find(board, word, wordIndex+1, i+1, j) ||
                    find(board, word, wordIndex+1, i, j+1);
            board[i][j] = c;
            return result;
        }
        return false;
    }
}
