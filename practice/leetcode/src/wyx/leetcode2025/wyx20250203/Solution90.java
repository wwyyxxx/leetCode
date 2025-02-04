package practice.leetcode.src.wyx.leetcode2025.wyx20250203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: Tungbo
 * @Date: 2025-02-05 00:06:50
 * @LastEditTime: 2025-02-05 00:41:19
 * @LastEditors: Tungbo
 * @Description: leecode: 90. 子集 II
 */
public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, res, new ArrayList<>());
        return res;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> res, List<Integer> path) {
        res.add(new ArrayList<Integer>(path));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            path.add(nums[j]);
            dfs(j+1, nums, res, path);
            path.remove(path.size() - 1);
        }
    }
}
