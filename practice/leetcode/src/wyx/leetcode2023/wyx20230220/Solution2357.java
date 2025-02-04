/*
 * @Author: Tungbo
 * @Date: 2023-02-24 11:51:45
 * @LastEditTime: 2023-02-24 12:03:21
 * @LastEditors: Tungbo
 * @Description: leecode: 2357. 使数组中所有元素都等于零
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230220;

import java.util.HashSet;
import java.util.Set;

public class Solution2357 {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(num != 0)set.add(num);
        }
        return set.size();
    }
}
