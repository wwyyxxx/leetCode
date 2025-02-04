/*
 * @Author: Tungbo
 * @Date: 2024-07-23 19:28:26
 * @LastEditTime: 2024-07-23 19:33:56
 * @LastEditors: Tungbo
 * @Description: leecode: 35. 搜索插入位置
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240722;

public class Solution22 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
