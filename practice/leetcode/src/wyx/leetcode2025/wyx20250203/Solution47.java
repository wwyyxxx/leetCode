package practice.leetcode.src.wyx.leetcode2025.wyx20250203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: Tungbo
 * @Date: 2025-02-06 00:06:50
 * @LastEditTime: 2025-02-06 12:12:28
 * @LastEditors: Tungbo
 * @Description: leecode: 47. 全排列 II
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        boolean[] memo = new boolean[nums.length];
        dfs(0, nums, res, new ArrayList<Integer>(), memo);
        return res;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] memo) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (memo[j]) {
               continue; 
            }
            if(j > 0 && nums[j] == nums[j - 1] && !memo[j - 1]) {
                continue;
            }
            memo[j] = true;
            path.add(nums[j]);
            dfs(i + 1, nums, res, path, memo);
            path.remove(path.size() - 1);
            memo[j] = false;
        }
    }
}
