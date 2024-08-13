/*
 * @Author: Tungbo
 * @Date: 2024-08-13 16:38:35
 * @LastEditTime: 2024-08-13 19:31:05
 * @LastEditors: Tungbo
 * @Description: leecode: 322. 零钱兑换
 */
package wyx.leetcode2024.wyx20240805;

import java.util.Arrays;

public class Solution322 {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[amount];

        return findWay(coins, amount);
    }

    
    private int findWay(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }
        
        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res =  findWay(coins, amount - coins[i]);
            if(res >= 0 && res < min) {
                min = res + 1;
            }
        }
        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];
    }

    public int coinChange1(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1);
                }
            }
        }
        return memo[amount] == amount + 1 ? -1 : memo[amount];
    }
}
