package offer.middle;

public class Offer12 {

    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        // 递归，遍历矩阵中每一个格子，从该格子的上下左右四个方向查找
        /**
         * 递归结束条件：
         * 1）word 中每个字符都能匹配上，wordIndex == word.length，return true
         * 2）水平方向指针或者竖直方向指针越界，return false
         * 3）word[wordIndex] != board[i][j] ，return false
         * 递归内容：
         * 1）从上下左右四个方向，看能不能找到 word[word+1]
         */
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (help(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean help(char[][] board, String word, int wordIndex, int i, int j) {
        if (word.length() == wordIndex) {
            return true;
        }
        if (i < 0 || i >= board.length) {
            return false;
        }
        if (j < 0 || j >= board[0].length) {
            return false;
        }
        if (word.charAt(wordIndex) == board[i][j]) {
            // 避免走回头路
            board[i][j] = '0';
            boolean nextResult = help(board, word, wordIndex+1, i-1, j)
                    || help(board, word, wordIndex+1, i, j-1)
                    || help(board, word, wordIndex+1, i+1, j)
                    || help(board, word, wordIndex+1, i, j+1);
            board[i][j] = word.charAt(wordIndex);
            return nextResult;
        }
        return false;
    }
}
