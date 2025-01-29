/*
 * @Author: Tungbo
 * @Date: 2025-01-29 14:08:42
 * @LastEditTime: 2025-01-29 14:12:15
 * @LastEditors: Tungbo
 * @Description: leecode: 219. 存在重复元素 II
 */
package wyx.leetcode2024.wyx20250128;

import java.util.HashMap;
import java.util.Map;

public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i + j < nums.length && nums[i+j] == nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer,Integer> dic = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dic.containsKey(nums[i]) && i - dic.get(nums[i]) <= k) {
                return true;
            }
            dic.put(nums[i], i);
        }
        return false;
    }
}
