/*
 * @Author: Tungbo
 * @Date: 2024-06-15 23:17:53
 * @LastEditTime: 2024-06-15 23:17:57
 * @LastEditors: Tungbo
 * @Description: leecode: 53. 最大子数组和
 */
package wyx.leetcode2024.wyx20240610;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for(int i = 1; i < len; i++) {
            if(dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
