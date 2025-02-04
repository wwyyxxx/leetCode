package practice.leetcode.src.wyx.leetcode2025.wyx20250203;
/*
 * @Author: Tungbo
 * @Date: 2025-02-03 10:05:30
 * @LastEditTime: 2025-02-04 17:29:25
 * @LastEditors: Tungbo
 * @Description: leecode: 922. 按奇偶排序数组 II
 */
public class Solution922 {
    public int[] sortArrayByParityII(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0, j = 1;
        for (int idx = 0; idx < res.length; idx++) {
            if(nums[idx] % 2 == 0) {
                res[i] = nums[idx];
                i+=2;
            } else {
                res[j] = nums[idx];
                j+=2;
            }
        }
        return res;
    }
}
