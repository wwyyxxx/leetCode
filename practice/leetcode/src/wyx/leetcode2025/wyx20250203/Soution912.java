/*
 * @Author: Tungbo
 * @Date: 2025-02-07 00:23:31
 * @LastEditTime: 2025-02-07 00:38:48
 * @LastEditors: Tungbo
 * @Description: leecode: 912. 排序数组
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250203;

public class Soution912 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivotIndex = partition(nums, l, r);
        quickSort(nums, l, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int privot = nums[l];
        int lt = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] <= privot) {
                lt++;
                swap(nums, lt, i);
            }
        }
        swap(nums, l, lt);
        return lt;
    }

    private void swap(int[] nums, int low, int i) {
        int temp = nums[i];
        nums[i] = nums[low];
        nums[low] = temp;
    }
}