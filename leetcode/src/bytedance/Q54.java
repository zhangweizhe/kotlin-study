package bytedance;

import java.util.ArrayList;
import java.util.List;

public class Q54 {
    public static void main(String[] args) {
        // 54. 螺旋矩阵
        // https://leetcode.cn/problems/spiral-matrix/
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        Direction direction = Direction.RIGHT;
        int columnCount = matrix[0].length;
        int rowCount = matrix.length;
        int leftIndex = 0;
        int rightIndex = columnCount - 1;
        int topIndex = 0;
        int bottomIndex = rowCount - 1;
        int count = columnCount * rowCount;
        List<Integer> result = new ArrayList<>(count);
        for (int i=0; i<count;) {
            switch (direction) {
                case RIGHT:
                    for (int j=leftIndex; j<=rightIndex; j++) {
                        result.add(matrix[topIndex][j]);
                        i++;
                    }
                    direction = Direction.DOWN;
                    topIndex++;
                    break;
                case DOWN:
                    for (int j=topIndex; j<=bottomIndex; j++) {
                        result.add(matrix[j][rightIndex]);
                        i++;
                    }
                    direction = Direction.LEFT;
                    rightIndex--;
                    break;
                case LEFT:
                    for (int j=rightIndex; j>=leftIndex; j--) {
                        result.add(matrix[bottomIndex][j]);
                        i++;
                    }
                    direction = Direction.UP;
                    bottomIndex--;
                    break;
                case UP:
                    for (int j=bottomIndex; j>=topIndex; j--) {
                        result.add(matrix[j][leftIndex]);
                        i++;
                    }
                    leftIndex++;
                    direction = Direction.RIGHT;
                    break;
            }
        }
        return result;
    }

    enum Direction {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }
}
