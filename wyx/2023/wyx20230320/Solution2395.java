/*
 * @Author: Tungbo
 * @Date: 2023-03-26 20:42:36
 * @LastEditTime: 2023-03-26 20:45:02
 * @LastEditors: Tungbo
 * @Description: leecode: 2395. 和相等的子数组
 */
package wyx.wyx20230320;

import java.util.HashSet;
import java.util.Set;

public class Solution2395 {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i-1] + nums[i];
            if(!set.add(sum)) return true;
        }
        return false;
    }
}
