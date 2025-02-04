package practice.leetcode.src.wyx.leetcode2024.wyx20240415;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author: Tungbo
 * @Date: 2024-04-21 22:53:36
 * @LastEditTime: 2024-04-22 15:05:53
 * @LastEditors: Tungbo
 * @Description: leecode:  216. 组合总和 III
 */
public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>(k);
        dfs(9, n, k, ans, path);
        return ans;
    }

    private void dfs(int i, int t, int k, List<List<Integer>> ans, List<Integer> path) {
        int d = k - path.size(); // 还要选 d 个数
        if (t < 0 || t > (i * 2 - d + 1) * d / 2) { // 剪枝
            return; // (18 - 3 + 1) * 3 / 2
        }
        if (d == 0) { // 找到一个合法组合
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j >= d; j--) {
            path.add(j);
            dfs(j - 1, t - j, k, ans, path);
            path.remove(path.size() - 1);
        }
    }
}
