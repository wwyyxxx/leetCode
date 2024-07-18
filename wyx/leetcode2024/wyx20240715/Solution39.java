/*
 * @Author: Tungbo
 * @Date: 2024-07-18 15:48:53
 * @LastEditTime: 2024-07-18 16:20:17
 * @LastEditors: Tungbo
 * @Description: leecode: 39. 组合总和
 */
package wyx.leetcode2024.wyx20240715;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        
        backtrack(0, candidates, target, new ArrayList<>());

        return res;
    }

    private void backtrack(int idx, int[] candidates, int target, List<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }
        if (idx == candidates.length) {
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(idx, candidates, target - candidates[i], path);
            path.remove(path.size() - 1);
        }
    }
}
