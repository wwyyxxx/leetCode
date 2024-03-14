/*
 * @Author: Tungbo
 * @Date: 2024-03-14 11:07:01
 * @LastEditTime: 2024-03-14 11:24:45
 * @LastEditors: Tungbo
 * @Description: leecode: 2789. 合并后数组中的最大元素
 */
package wyx.leetcode2024.wyx20240311;

public class Solution2789 {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long res[] = new long[n];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            if (res[i+1] >= res[i]) {
                res[i] += res[i+1];
            }
        }
        return res[0];
    }

    public long maxArrayValue1(int[] nums) {
        int n = nums.length;
        long res = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            res = nums[i] <= res ? nums[i] + res : nums[i];
        }
        return res;
    }
}
