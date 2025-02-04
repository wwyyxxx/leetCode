/*
 * @Author: Tungbo
 * @Date: 2024-09-19 21:27:32
 * @LastEditTime: 2024-09-19 22:20:59
 * @LastEditors: Tungbo
 * @Description: leecode: 416. 分割等和子集
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240916;

import java.util.Arrays;

public class Solution416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        // Arrays.sort(nums);
        if (sum % 2 != 0) {
            return false;
        }
        int target =sum / 2;
        boolean[][] dp = new boolean[n][];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] |  dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }
}