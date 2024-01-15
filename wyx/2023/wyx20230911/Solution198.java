/*
 * @Author: Tungbo
 * @Date: 2023-09-18 13:55:52
 * @LastEditTime: 2023-09-18 13:55:54
 * @LastEditors: Tungbo
 * @Description: leecode: 198. 打家劫舍
 */
package wyx.wyx20230911;

public class Solution198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n <= 1) return nums[0];

        // int[] dp = new int[n];
        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]);

        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            int t = Math.max(prev + nums[i], curr);
            prev = curr;
            curr = t;
            // dp[i] = Math.max(prev + nums[i], curr);
        }
        return curr;
    }
}
