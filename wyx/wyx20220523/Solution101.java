package wyx.wyx20220523;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: Tungbo
 * @Date: 2022-05-25 23:06:51
 * @LastEditTime: 2022-07-11 11:05:16
 * @LastEditors: Tungbo
 * @Description: leecode:  剑指 Offer II 101. 分割等和子集
 * 
 * 给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。
 * 
 */
public class Solution101 {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n<2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for(int num : nums) {
            sum += num;
            maxNum = Math.max(num, maxNum);
        }
        if(sum % 2 != 0) {
            return false;
        }
        int target = sum /2;
        if(maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[n][target+1];
        for(int i = 0; i < n; i++) {
            dp[i][0] = true; 
        }
        dp[0][nums[0]] = true;
        for(int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if(j >= num) {
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-num];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][target];
    }

}