/*
 * @Author: Tungbo
 * @Date: 2024-07-17 15:52:39
 * @LastEditTime: 2024-07-17 16:14:59
 * @LastEditors: Tungbo
 * @Description: leecode: 78. 子集
 */
package wyx.leetcode2024.wyx20240715;

import java.util.ArrayList;
import java.util.List;


public class Solution78 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        dfs(0, nums, new ArrayList<>(),visited);
        return res;
    }

    private void dfs(int idx, int[] nums, List<Integer> path, boolean[] visited) {
        res.add(new ArrayList<>(path));
        if(idx == nums.length) return;
        for (int i = idx; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(i + 1, nums, path, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }


}
