/*
 * @Author: Tungbo
 * @Date: 2025-02-16 13:12:58
 * @LastEditTime: 2025-02-16 13:24:45
 * @LastEditors: Tungbo
 * @Description: leecode: 643. 子数组最大平均数 I
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250210;

public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            if (i < k -1) {
                continue;
            }
            maxSum = Math.max(maxSum,s);
            s -= nums[i - k + 1];
        }
        return (double) maxSum / k;
    }
}
