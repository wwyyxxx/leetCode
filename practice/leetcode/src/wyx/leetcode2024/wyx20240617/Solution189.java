/*
 * @Author: Tungbo
 * @Date: 2024-06-17 19:53:23
 * @LastEditTime: 2024-06-17 20:24:31
 * @LastEditors: Tungbo
 * @Description: leecode: 189. 轮转数组
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240617;

import java.util.Arrays;

public class Solution189 {
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end]  = temp;
            start++;
            end++;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < nums.length; i++) {
            newArr[i % k] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
