/*
 * @Author: Tungbo
 * @Date: 2022-09-12 16:09:05
 * @LastEditTime: 2022-09-12 16:19:22
 * @LastEditors: Tungbo
 * @Description: leecode: 1608. 特殊数组的特征值
 * 
 * 你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值
 * 注意： x 不必 是 nums 的中的元素
 * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220912;

import java.util.Arrays;

public class Solution1608 {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int n = nums.length - i;
            if (nums[i] >= n) {
                if (i != 0 && nums[i - 1] >= n) continue;
                return n;
            }
        }
        return -1;
    }

}
