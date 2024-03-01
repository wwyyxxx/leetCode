/*
 * @Author: Tungbo
 * @Date: 2024-03-01 10:41:51
 * @LastEditTime: 2024-03-01 11:02:10
 * @LastEditors: Tungbo
 * @Description: leecode: 2369. 检查数组是否存在有效划分
 */
package wyx.leetcode2024.wyx20240226;

public class Solution2369 {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] && nums[i] == nums[i - 1]
                    || i > 1 && dp[i - 2] && (nums[i] == nums[i - 1] && nums[i] == nums[i - 2]
                            || nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2))
                dp[i + 1] = true;
        }
        return dp[n];
    }
}
