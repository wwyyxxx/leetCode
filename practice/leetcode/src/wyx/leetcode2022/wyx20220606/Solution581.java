/*
 * @Author: Tungbo
 * @Date: 2022-06-10 11:03:43
 * @LastEditTime: 2022-06-10 11:08:42
 * @LastEditors: Tungbo
 * @Description: leecode: 581. 最短无序连续子数组
 * 
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220606;

import java.util.Arrays;

public class Solution581 {
    
    public int findUnsortedSubarray(int[] nums) {
        //复制一个数组，并排序好 用于比较
        int[] temp = Arrays.copyOf(nums,nums.length);
        Arrays.sort(temp);
        int l = -1, r = -1;
        for(int i = 0; i < nums.length; i++) {
            if(temp[i] != nums[i]) {
                //记录最开始不一样的下标
                if(l== -1) l = i;
                else r = i + 1; //最后的下标
            }
        }
        return r - l;
    }

}
