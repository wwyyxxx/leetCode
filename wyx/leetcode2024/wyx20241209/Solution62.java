/*
 * @Author: Tungbo
 * @Date: 2024-12-13 15:07:05
 * @LastEditTime: 2024-12-13 16:17:24
 * @LastEditors: Tungbo
 * @Description: leecode: 62. 不同路径
 */
package wyx.leetcode2024.wyx20241209;

public class Solution62 {
    public int uniquePaths(int m, int n) {
        int i, j = 0;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (i == 0 && j == 0) continue;
                dp[i][j] = dp[Math.max(i - 1, 0)][j] + dp[i][Math.max(j - 1, 0)];
            }
        }
        return dp[m-1][n-1];
    }
}
