/*
 * @Author: Tungbo
 * @Date: 2024-08-11 17:31:31
 * @LastEditTime: 2024-08-11 17:39:29
 * @LastEditors: Tungbo
 * @Description: leecode: 279. 完全平方数
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240805;

import java.util.Arrays;

public class Solution279 {

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}