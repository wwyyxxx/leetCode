/*
 * @Author: Tungbo
 * @Date: 2024-07-26 17:49:57
 * @LastEditTime: 2024-07-26 19:05:17
 * @LastEditors: Tungbo
 * @Description: leecode: 153. 寻找旋转排序数组中的最小值
 */
package wyx.leetcode2024.wyx20240722;

public class Solution153 {

    public int findMin(int[] nums) {
        int left =  0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}