/*
 * @Author: Tungbo
 * @Date: 2024-04-08 09:46:13
 * @LastEditTime: 2024-04-09 10:59:09
 * @LastEditors: Tungbo
 * @Description: leecode: 2009. 使数组连续的最少操作数
 */
package wyx.leetcode2024.wyx20240408;

import java.util.Arrays;

public class Solution2009 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int j = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j++] = nums[i]; // 原地去重
            }
        }

        int ans = 0;
        int left = 0;
        for (int i = 0; i < j; i++) {
            while (nums[left] < nums[i] - n + 1) { // nums[left] 不在窗口内
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return n - ans;
    }
}
