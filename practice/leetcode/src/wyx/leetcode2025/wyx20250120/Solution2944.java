/*
 * @Author: Tungbo
 * @Date: 2025-01-24 00:55:57
 * @LastEditTime: 2025-01-24 01:26:06
 * @LastEditors: Tungbo
 * @Description: leecode: 2944. 购买水果需要的最少金币数
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250120;

import java.util.List;

public class Solution2944 { 

    public int minimumCoins(int[] prices) {
        int n = prices.length;
        int[] memo = new int[(n+1)/2];
        return dfs(1, prices, memo);
    }

    private int dfs(int i, int[] prices, int[] memo) {
        if(i * 2 >= prices.length) {
            return prices[i - 1];
        }
        if(memo[i] != 0) {
            return memo[i];
        }
        int res = Integer.MAX_VALUE;
        for(int j = i + 1; j <= i * 2 + 1; j++) {
            res = Math.min(res, dfs(j, prices, memo));
        }
        return memo[i] = res + prices[i - 1];
    }
}