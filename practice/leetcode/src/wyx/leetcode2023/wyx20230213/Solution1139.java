/*
 * @Author: Tungbo
 * @Date: 2023-02-17 14:30:33
 * @LastEditTime: 2023-02-17 14:30:36
 * @LastEditors: Tungbo
 * @Description: leecode: 1139. 最大的以 1 为边界的正方形
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230213;

public class Solution1139 {
    public int largest1BorderedSquare(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int[][][] dp = new int[n+1][m+1][2];
        for(int i = 1; i<=n;i++) {
            for(int j = 1; j<=m;j++){
                if(grid[i-1][j-1] == 0) continue;
                dp[i][j][0] = dp[i][j-1][0] + 1;
                dp[i][j][1] = dp[i-1][j][1] + 1;
            }
        }
        int maxEgde = 0;
        for(int i = 1; i<=n;i++) {
            for(int j = 1; j<=m;j++){
                int curEgde = Math.min(dp[i][j][0],dp[i][j][1]);
                if(curEgde <= maxEgde) continue;
                for(;curEgde > maxEgde; curEgde--) {
                    if(dp[i][j - curEgde + 1][1] >=curEgde && dp[i- curEgde + 1][j][0] >=curEgde) {
                        maxEgde = curEgde;
                        break;
                    }
                }
            }
        }
        return maxEgde * maxEgde;
    }
}
