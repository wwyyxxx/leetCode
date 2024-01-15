/*
 * @Author: Tungbo
 * @Date: 2022-08-09 11:02:51
 * @LastEditTime: 2022-08-09 11:26:50
 * @LastEditors: Tungbo
 * @Description: leecode: 1413. 逐步求和得到正数的最小值
 * 
 * 给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值
 * 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值
 * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 
 * 
 */
package wyx.wyx20220808;

public class Solution1413 {

    public int minStartValue(int[] nums) {
        int maxMin = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < maxMin && sum <= 0) {
                sum = maxMin;
            }
        }
        return sum > 0 ? 1 : 1 - sum;
    }

}
