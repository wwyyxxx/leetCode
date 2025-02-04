package practice.leetcode.src.wyx.leetcode2022.wyx20220516;

import java.util.HashSet;
import java.util.Set;

/*
 * @Author: Tungbo
 * @Date: 2022-05-20 15:38:25
 * @LastEditTime: 2022-05-26 21:58:12
 * @LastEditors: Tungbo
 * @Description: leecode: 128. 最长连续序列
 * 
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 
 * 
 */
public class Solution128 {
    

    //Set过滤之后，再集合里查找
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int res = 0;
        for(Integer num : set) {
            if(!set.contains(num-1)) {
                int temp = num;
                int stack = 0;
                while(set.contains(temp)) {
                    stack++;
                    temp++;
                }
                res = Math.max(res,stack);
            }
        }
        return res;
    }
}
