/*
 * @Author: Tungbo
 * @Date: 2023-03-08 11:08:06
 * @LastEditTime: 2023-03-13 14:40:01
 * @LastEditors: Tungbo
 * @Description: leecode: 剑指 Offer 47. 礼物的最大价值
 */
package wyx.wyx20230306;

public class Solution47 {
    public int maxValue(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for(int i = 0;i < n; i++) {
            for(int j = 0;j < m; j++) {
                if(i ==0 && j== 0) continue;
                if(i == 0) grid[i][j] += grid[i][j-1];
                else if(j == 0) grid[i][j] += grid[i-1][j];
                else {
                    grid[i][j] += Math.max(grid[i-1][j],grid[i][j-1]);
                }
            }
        }
        return grid[n-1][m-1];
    }
}
