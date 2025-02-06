/*
 * @Author: Tungbo
 * @Date: 2025-02-06 12:14:03
 * @LastEditTime: 2025-02-06 12:15:15
 * @LastEditors: Tungbo
 * @Description: leecode: 46. 全排列
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250203;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        boolean[] visit = new boolean[nums.length];
        dfs(0, nums, res, new ArrayList<Integer>(), visit);
        return res;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] visit) {
        if (nums.length == path.size()) {
           res.add(new ArrayList<>(path));
           return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (visit[j]) {
                continue;
            }
            visit[j] =true;
            path.add(nums[j]);
            dfs(i+1, nums, res, path,visit);
            path.remove(path.size() - 1);
            visit[j] =false;
        }
    }
}
