/*
 * @Author: Tungbo
 * @Date: 2024-06-13 20:02:08
 * @LastEditTime: 2024-06-13 20:39:02
 * @LastEditors: Tungbo
 * @Description: leecode: 560. 和为 K 的子数组
 */
package wyx.leetcode2024.wyx20240610;

public class Solution269 {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;

        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
