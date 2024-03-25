/*
 * @Author: Tungbo
 * @Date: 2024-03-25 21:04:14
 * @LastEditTime: 2024-03-25 21:59:37
 * @LastEditors: Tungbo
 * @Description: leecode: 518. 零钱兑换 II
 */
package wyx.leetcode2024.wyx20240325;

public class Solution518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
