package practice.leetcode.src.wyx.leetcode2024.wyx20240805;

/*
 * @Author: Tungbo
 * @Date: 2024-08-05 16:26:18
 * @LastEditTime: 2024-08-10 18:40:51
 * @LastEditors: Tungbo
 * @Description: leecode: 198. 打家劫舍
 */
public class Solution198 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}