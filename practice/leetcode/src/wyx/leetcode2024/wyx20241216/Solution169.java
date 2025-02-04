package practice.leetcode.src.wyx.leetcode2024.wyx20241216;

import java.util.HashMap;
import java.util.Map;
/*
 * @Author: Tungbo
 * @Date: 2024-12-16 22:40:56
 * @LastEditTime: 2024-12-16 22:50:56
 * @LastEditors: Tungbo
 * @Description: leecode: 169. 多数元素
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> dic = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            dic.put(nums[i], dic.getOrDefault(nums[i], 0) + 1);
        }
        int res = nums[0];
        for(Map.Entry<Integer,Integer> entry : dic.entrySet()) {
            if (entry.getValue() > dic.get(res)) {
                res = entry.getKey();
            }
        }
        return res;
    }
}
