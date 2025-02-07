/*
 * @Author: Tungbo
 * @Date: 2025-02-08 00:30:15
 * @LastEditTime: 2025-02-08 00:30:18
 * @LastEditors: Tungbo
 * @Description: leecode: 62. 不同路径
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250203;

import java.util.Arrays;

public class Solution62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
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
