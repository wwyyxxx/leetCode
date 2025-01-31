/*
 * @Author: Tungbo
 * @Date: 2025-02-01 01:53:06
 * @LastEditTime: 2025-02-01 01:53:25
 * @LastEditors: Tungbo
 * @Description: leecode: 81. 搜索旋转排序数组 II
 */
package wyx.leetcode2024.wyx20250128;

public class Solution81 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid]) {
                l++;
                continue;
            }
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
