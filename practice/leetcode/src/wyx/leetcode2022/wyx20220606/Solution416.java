/*
 * @Author: Tungbo
 * @Date: 2022-06-07 13:00:13
 * @LastEditTime: 2022-06-07 14:36:35
 * @LastEditors: Tungbo
 * @Description: leecode: 416. 分割等和子集
 * 
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220606;

public class Solution416 {
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int maxnum = 0;
        for(int i : nums) {
            sum +=i;
            maxnum = Math.max(maxnum,i);
        }
        //两个子集  非偶数false
        if(sum % 2 != 0) return false;
        int target = sum /2;
        //target小于最大的数 则需要减去 所以false
        if(target < maxnum) return false;

        //动态规划 填出0~target的可能性
        //dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]  j>nums[i]
        //dp[i][j] = dp[i-1][j]    j<=nums[i]
        boolean[][] dp = new boolean[nums.length][target+1];
        for(int i =0;i<nums.length;i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for(int i = 1;i<nums.length;i++) {
            int num = nums[i];
            for(int j = 1; j <= target; j++) {
                if(num < j) {
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-num];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][target];
    }

}
