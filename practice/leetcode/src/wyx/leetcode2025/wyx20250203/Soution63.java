/*
 * @Author: Tungbo
 * @Date: 2025-02-08 00:05:54
 * @LastEditTime: 2025-02-08 00:24:23
 * @LastEditors: Tungbo
 * @Description: leecode: 63. 不同路径 II
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250203;

import java.util.Arrays;

public class Soution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                int x = i > 0 ? dp[i - 1][j] : 0;
                int y = j > 0 ? dp[i][j - 1] : 0;
                dp[i][j] = x + y;
            }
        }
        return dp[m - 1][n - 1];
    }
}
