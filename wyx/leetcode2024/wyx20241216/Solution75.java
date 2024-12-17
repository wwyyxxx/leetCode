package wyx.leetcode2024.wyx20241216;
/*
 * @Author: Tungbo
 * @Date: 2024-12-117 22:40:56
 * @LastEditTime: 2024-12-16 22:50:56
 * @LastEditors: Tungbo
 * @Description: leecode: 75. 颜色分类
 */
public class Solution75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            int temp = nums[i];
            while (j > 0 && temp < nums[j - 1]) {
                nums[j-1] = nums[j];
                j--;
            }
            nums[j] = nums[i];
        }
    }
}
