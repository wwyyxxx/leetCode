/*
 * @Author: Tungbo
 * @Date: 2023-01-16 13:28:14
 * @LastEditTime: 2023-01-16 13:28:16
 * @LastEditors: Tungbo
 * @Description: leecode: 2293. 极大极小游戏
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230109;

public class Solution2239 {
    public int minMaxGame(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] newNums = new int[nums.length / 2];
        for(int i = 0; i < newNums.length; i++) {
            newNums[i] = i %2 ==0 ? Math.min(nums[2*i],nums[2*i+1]) : Math.max(nums[2*i],nums[2*i+1]) ;
        }
        return minMaxGame(newNums);
    }
}
