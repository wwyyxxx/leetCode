/*
 * @Author: Tungbo
 * @Date: 2024-07-17 15:05:42
 * @LastEditTime: 2024-07-17 15:51:55
 * @LastEditors: Tungbo
 * @Description: leecode: 46. 全排列
 */
package wyx.leetcode2024.wyx20240715;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution46 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        dfs(0, nums, new ArrayList<>(), visited);
        return res;
    }

    private void dfs(int i, int[] nums, List<Integer> path, boolean[] visited) {
        if (i == nums.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (visited[j]) {
                continue;
            }
            visited[j] = true;
            path.add(nums[j]);
            System.out.println(Arrays.toString(path.toArray()));
            dfs(i + 1, nums, path,visited);
            path.remove(path.size() - 1);
            visited[j] = false;
        }
    }
}
