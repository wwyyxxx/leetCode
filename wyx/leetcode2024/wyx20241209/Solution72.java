/*
 * @Author: Tungbo
 * @Date: 2024-12-15 18:53:44
 * @LastEditTime: 2024-12-15 19:09:37
 * @LastEditors: Tungbo
 * @Description: leecode: 72. 编辑距离
 */
package wyx.leetcode2024.wyx20241209;

public class Solution72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] + 1;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j-1] + 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i -1][j -1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
