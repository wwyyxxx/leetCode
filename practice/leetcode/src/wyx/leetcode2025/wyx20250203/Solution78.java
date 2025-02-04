/*
 * @Author: Tungbo
 * @Date: 2025-02-05 01:00:01
 * @LastEditTime: 2025-02-05 01:00:20
 * @LastEditors: Tungbo
 * @Description: leecode: 78. 子集
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250203;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(0, nums, res, new ArrayList<>());
        return res;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> res, List<Integer> path) {
        res.add(new ArrayList<Integer>(path));
        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            dfs(j+1, nums, res, path);
            path.remove(path.size() - 1);
        }
    }
}
