/*
 * @Author: Tungbo
 * @Date: 2024-03-16 23:04:19
 * @LastEditTime: 2024-03-16 23:56:17
 * @LastEditors: Tungbo
 * @Description: leecode: 2684. 矩阵中移动的最大次数
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240311;

public class Solution2684 {
    int[][] grid;
    int m, n;

    public int maxMoves(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, dfs(i, 0, 0));
        }
        return ans;
    }

    private int dfs(int i, int j, int move) {
        if (i >= m || j >= n)
            return move;
        int move1 = move, move2 = move, move3 = move;
        if (j + 1 < n && grid[i][j] < grid[i][j + 1]) {
            move1 = dfs(i, j + 1, move + 1);
        }
        if (i - 1 >= 0 && j + 1 < n && grid[i][j] < grid[i - 1][j + 1]) {
            move2 = dfs(i - 1, j + 1, move + 1);
        }
        if (i + 1 < m && j + 1 < n && grid[i][j] < grid[i + 1][j + 1]) {
            move3 = dfs(i + 1, j + 1, move + 1);
        }
        grid[i][j] =0;
        return Math.max(Math.max(move1, move2), move3);
    }
}
