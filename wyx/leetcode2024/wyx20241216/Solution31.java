/*
 * @Author: Tungbo
 * @Date: 2024-12-18 19:49:25
 * @LastEditTime: 2024-12-18 20:50:06
 * @LastEditors: Tungbo
 * @Description: leecode: 31. 下一个排列
 */
package wyx.leetcode2024.wyx20241216;

public class Solution31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //从后往前，找到第一个升序的首位
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            //找到比 i 大的 j，并交换它们
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
