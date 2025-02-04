/*
 * @Author: Tungbo
 * @Date: 2022-11-24 10:34:14
 * @LastEditTime: 2022-11-24 14:31:03
 * @LastEditors: Tungbo
 * @Description: leecode: 795. 区间子数组个数
 * 
 * 给你一个整数数组 nums 和两个整数：left 及 right 。
 * 找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组，并返回满足条件的子数组的个数。
 * 生成的测试用例保证结果符合 32-bit 整数范围。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221121;

//[2,1,4,3], left = 2, right = 3
public class Solution795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    public int count(int[] nums, int lower) {
        int res = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt = nums[i] <= lower ? cnt + 1 : 0;
            res += cnt;
        }
        return res;
    }

    public int numSubarrayBoundedMax1(int[] nums, int left, int right) {
        int res = 0, i0  = -1, i1 = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > right) i0 = i;
            if(nums[i] >= left) i1 = i;
            res += i1 - i0;
        }
        return res;
    }
}
