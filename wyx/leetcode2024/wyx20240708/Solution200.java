/*
 * @Author: Tungbo
 * @Date: 2024-07-12 17:30:14
 * @LastEditTime: 2024-07-12 17:43:19
 * @LastEditors: Tungbo
 * @Description: leecode: 200. 岛屿数量
 */
package wyx.leetcode2024.wyx20240708;

public class Solution200 {

    int m, n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
