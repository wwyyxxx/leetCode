/*
 * @Author: Tungbo
 * @Date: 2024-07-24 19:13:40
 * @LastEditTime: 2024-07-24 19:26:02
 * @LastEditors: Tungbo
 * @Description: leecode: 34. 在排序数组中查找元素的第一个和最后一个位置
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240722;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1;
        int first = -1, last = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                first = mid;
                right = mid -1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{first, last};
    }
}
