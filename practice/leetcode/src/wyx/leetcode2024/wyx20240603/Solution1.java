/*
 * @Author: Tungbo
 * @Date: 2024-06-04 21:59:19
 * @LastEditTime: 2024-06-04 21:59:23
 * @LastEditors: Tungbo
 * @Description: leecode: 1. 两数之和
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240603;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> dic = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(dic.containsKey(nums[i])) 
                return new int[]{dic.get(nums[i]),i};
            dic.put(target - nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
