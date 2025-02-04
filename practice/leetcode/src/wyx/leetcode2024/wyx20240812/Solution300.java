/*
 * @Author: Tungbo
 * @Date: 2024-08-18 20:43:42
 * @LastEditTime: 2024-08-18 21:19:29
 * @LastEditors: Tungbo
 * @Description: leecode: 300. 最长递增子序列
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240812;

import java.util.Arrays;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
