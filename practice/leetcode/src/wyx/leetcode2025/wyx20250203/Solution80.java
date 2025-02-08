/*
 * @Author: Tungbo
 * @Date: 2025-02-09 00:13:57
 * @LastEditTime: 2025-02-09 00:26:29
 * @LastEditors: Tungbo
 * @Description: leecode: 80. 删除有序数组中的重复项 II
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250203;

public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int cur = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[cur - 2]) {
                nums[cur++] = nums[i];
            }
        }
        return cur;
    }
}
