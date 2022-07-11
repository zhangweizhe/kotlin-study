package bytedance;

public class Q200 {

    public static void main(String[] args) {
        // 200. 岛屿数量
        // https://leetcode.cn/problems/number-of-islands/
    }

    public int numIslands(char[][] grid) {
        // 双循环遍历每个元素，如果是1，就count++，然后对其执行dfs；
        // dfs 算法中，如果遍历到0，就返回；如果是1，就将其置为0，表示已经访问过了，然后递归访问左上右下四个元素
        if (grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length) {
            return;
        }
        if (y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x-1, y);
        dfs(grid, x, y-1);
        dfs(grid, x+1, y);
        dfs(grid, x, y+1);
    }

}
