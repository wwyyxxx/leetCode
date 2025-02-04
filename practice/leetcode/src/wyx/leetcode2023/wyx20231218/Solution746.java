/*
 * @Author: Tungbo
 * @Date: 2023-12-17 16:27:22
 * @LastEditTime: 2023-12-17 17:23:44
 * @LastEditors: Tungbo
 * @Description: leecode: 746. 使用最小花费爬楼梯
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20231218;

public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2) return Math.min(cost[0], cost[1]); 
        int[] dp = new int[cost.length + 1];
        dp[0] = dp[1] = 0;
        int pre =0, curr = 0;
        for(int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i - 2] + cost[i-2]);
            int next = Math.min(curr + cost[i-1], pre + cost[i-2]);
            pre = curr;
            curr = next;
        }
        return curr;
    }
}
