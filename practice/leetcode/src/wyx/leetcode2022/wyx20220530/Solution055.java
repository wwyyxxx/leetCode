/*
 * @Author: Tungbo
 * @Date: 2022-06-05 11:08:30
 * @LastEditTime: 2022-06-05 11:53:41
 * @LastEditors: Tungbo
 * @Description: leecode: 55. 跳跃游戏
 * 
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220530;


public class Solution055 {
    
    public static void main(String[] args) {
        System.out.println(new Solution055().canJump(new int[] {2,0,0}));
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxJump = 0;
        for (int i = 0; i < n; i++) {
            //前进不了 被卡住的时候
            if(maxJump < i) return false;

            //记录能前进的最大的位置
            maxJump = Math.max(maxJump,i+nums[i]);
            
            //到尾部的时候直接返回
            if(maxJump >= n-1) return true;
        }
        return false;
    }
}
