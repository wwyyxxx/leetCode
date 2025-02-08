/*
 * @Author: Tungbo
 * @Date: 2025-02-09 00:29:26
 * @LastEditTime: 2025-02-09 00:29:30
 * @LastEditors: Tungbo
 * @Description: leecode: 26. 删除有序数组中的重复项
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250203;

public class Solutioon26 {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i-1]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
