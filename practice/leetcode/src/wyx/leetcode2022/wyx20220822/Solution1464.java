/*
 * @Author: Tungbo
 * @Date: 2022-08-26 14:45:24
 * @LastEditTime: 2022-08-26 14:46:26
 * @LastEditors: Tungbo
 * @Description: leecode: 1464. 数组中两元素的最大乘积
 * 
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * 请你计算并返回该式的最大值。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220822;

import java.util.Arrays;

public class Solution1464 {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
}
