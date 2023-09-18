/*
 * @Author: Tungbo
 * @Date: 2023-09-18 14:13:23
 * @LastEditTime: 2023-09-18 14:13:25
 * @LastEditors: Tungbo
 * @Description: leecode: 213. 打家劫舍 II
 */
package wyx.wyx20230911;

import java.util.Arrays;

public class Solution213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n <= 1) return nums[0];
        int[] arr1 = Arrays.copyOfRange(nums, 0, n - 1);
        int[] arr2 = Arrays.copyOfRange(nums, 1, n);
        return Math.max(robResult(arr1), robResult(arr2));
    }

    public int robResult(int[] nums) {
        int n = nums.length;
        if(n <= 1) return nums[0];
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            int t = Math.max(prev + nums[i], curr);
            prev = curr;
            curr = t;
        }
        return curr;
    }
}
