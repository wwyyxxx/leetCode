package practice.leetcode.src.wyx.leetcode2024.wyx20241209;

/*
 * @Author: Tungbo
 * @Date: 2024-12-14 19:31:41
 * @LastEditTime: 2024-12-14 19:52:40
 * @LastEditors: Tungbo
 * @Description: leecode:64. 最小路径和 
 */
public class Solution64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i== 0 && j== 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] += grid[i][j-1];
                } else if (j == 0) {
                    grid[i][j] += grid[i-1][j];
                } else {
                    grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
                }
                
            }
        }
        return grid[m-1][n-1];
    }
}
