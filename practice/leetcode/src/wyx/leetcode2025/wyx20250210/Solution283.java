/*
 * @Author: Tungbo
 * @Date: 2025-02-14 23:20:53
 * @LastEditTime: 2025-02-14 23:22:13
 * @LastEditors: Tungbo
 * @Description: leecode: 283. 移动零
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250210;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
