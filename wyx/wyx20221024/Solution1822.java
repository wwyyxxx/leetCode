package wyx.wyx20221024;

/*
 * @Author: Tungbo
 * @Date: 2022-10-27 10:49:18
 * @LastEditTime: 2022-10-27 10:51:33
 * @LastEditors: Tungbo
 * @Description: leecode: 1822. 数组元素积的符号
 * 
 * 已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
 *  如果 x 是正数，返回 1 。
 *  如果 x 是负数，返回 -1 。
 *  如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 * 返回 signFunc(product)
 * 
 */
public class Solution1822 {
    public int arraySign(int[] nums) {
        int ans = 1;
        for (int num : nums) {
            if (num == 0)
                return 0;
            ans *= num > 0 ? 1 : -1;
        }
        return ans;
    }
}
