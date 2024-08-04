/*
 * @Author: Tungbo
 * @Date: 2024-08-04 16:51:04
 * @LastEditTime: 2024-08-04 17:12:33
 * @LastEditors: Tungbo
 * @Description: leecode: 121. 买卖股票的最佳时机
 */
package wyx.leetcode2024.wyx20240729;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }
}
