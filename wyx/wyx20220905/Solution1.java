/*
 * @Author: Tungbo
 * @Date: 2022-09-06 11:36:49
 * @LastEditTime: 2022-09-06 11:37:54
 * @LastEditors: Tungbo
 * @Description: leecode: 1. 两数之和
 * 
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现
 * 你可以按任意顺序返回答案
 * 
 */
package wyx.wyx20220905;

import java.util.HashMap;

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{-1, -1};
    }
    
}
