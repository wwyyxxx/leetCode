/*
 * @Author: Tungbo
 * @Date: 2022-11-18 16:34:36
 * @LastEditTime: 2022-11-18 17:13:53
 * @LastEditors: Tungbo
 * @Description: leecode: 891. 子序列宽度之和
 * 
 * 一个序列的 宽度 定义为该序列中最大元素和最小元素的差值。
 * 给你一个整数数组 nums ，返回 nums 的所有非空 子序列 的 宽度之和 。
 * 由于答案可能非常大，请返回对 109 + 7 取余 后的结果
 * 子序列 定义为从一个数组里删除一些（或者不删除）元素，但不改变剩下元素的顺序得到的数组。
 * 例如，[3,6,2,7] 就是数组 [0,3,1,6,2,2,7] 的一个子序列
 * 
 */
package wyx.wyx20221114;

public class Solution891 {
    public int sumSubseqWidths(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int MOD = (int) 1e9 + 7;
        long ans = 0;
        int n = nums.length;
        int[] pow2 = new int[nums.length];
        pow2[0] = 1;
        for (int i = 1; i < pow2.length; i++) {
            pow2[i] = pow2[i - 1] * 2 % MOD;
        }
        for (int i = 0; i < nums.length; i++) {
            ans += (long) (pow2[i] - pow2[n - i - 1]) * nums[i];
        }
        return (int) (ans % MOD + MOD) % MOD;
    }
}
