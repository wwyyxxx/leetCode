/*
 * @Author: Tungbo
 * @Date: 2024-08-22 15:39:45
 * @LastEditTime: 2024-08-22 15:45:58
 * @LastEditors: Tungbo
 * @Description: leecode: 152. 乘积最大子数组
 */
package wyx.leetcode2024.wyx20240812;

public class Solution152 {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = imax;
            }

            imax = Math.max(imax * nums[i], nums[i]);

            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

}