package java.wyx20220509;

/*
 * @Author: Tungbo
 * @Date: 2022-05-12 18:55:12
 * @LastEditTime: 2022-05-12 19:39:20
 * @LastEditors: Tungbo
 * @Description: leecode:  乘积最大子序列
 * 
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 
 */
public class Solution152 {
    
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE, min = 1, max = 1;
        for (int i = 0; i < nums.length; i++) {

            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(nums[i] * max,nums[i]);
            min = Math.min(nums[i] * min, nums[i]);

        }
        ans = Math.max(max, min);
        return ans;
    }

}
