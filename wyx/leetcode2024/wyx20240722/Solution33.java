/*
 * @Author: Tungbo
 * @Date: 2024-07-25 19:15:04
 * @LastEditTime: 2024-07-25 19:21:25
 * @LastEditors: Tungbo
 * @Description: leecode: 33. 搜索旋转排序数组
 */
package wyx.leetcode2024.wyx20240722;

public class Solution33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? nums[0] : -1;
        }

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
