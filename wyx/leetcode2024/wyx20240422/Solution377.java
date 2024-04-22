/*
 * @Author: Tungbo
 * @Date: 2024-04-22 14:44:20
 * @LastEditTime: 2024-04-22 16:00:17
 * @LastEditors: Tungbo
 * @Description: leecode: 377. 组合总和 Ⅳ
 */
package wyx.leetcode2024.wyx20240422;

import java.util.Arrays;

public class Solution377 {
    
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        if (len <= 0) {
            return 0;
        }
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return dfs(target, nums, memo);
    }

    private int dfs(int target, int[] nums, int[] memo) {
        if(target == 0) return 1;
        if(memo[target] != -1) return memo[target];
        int res = 0;
        for(int x : nums) {
            if (x <= target) {
                res += dfs(target - x, nums, memo);
            }
        }
        return memo[target] = res;
    }
}
