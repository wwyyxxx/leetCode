/*
 * @Author: Tungbo
 * @Date: 2023-05-13 14:51:33
 * @LastEditTime: 2023-05-13 14:55:58
 * @LastEditors: Tungbo
 * @Description: leecode: 2441. 与对应负数同时存在的最大正整数
 */
package wyx.wyx20230509;

import java.util.HashSet;
import java.util.Set;

public class Solution2441 {
    public int findMaxK(int[] nums) {
        int ans = -1;
        Set<Integer> set = new HashSet<Integer>();
        for (int x:nums) set.add(x);
        for(int x:nums) {
            if(set.contains(-x)) {
                ans = Math.max(ans, x);
            }
        }
        return ans;
    }
}
