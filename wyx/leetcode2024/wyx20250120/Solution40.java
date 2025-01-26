/*
 * @Author: Tungbo
 * @Date: 2025-01-26 22:53:40
 * @LastEditTime: 2025-01-26 22:55:04
 * @LastEditors: Tungbo
 * @Description: leecode: 40. 组合总和 II
 */
package wyx.leetcode2024.wyx20250120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution40 {

    boolean[] vist;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        vist = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtrace(0, res, new ArrayList<Integer>(), candidates, target);
        return new ArrayList<>(res);
    }

    private void backtrace(int idx , Set<List<Integer>> res, List<Integer> path, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (idx == candidates.length) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (vist[i] || (i != 0 && candidates[i] == candidates[i-1])) {
                continue;
            }
            int temp = candidates[i];
            vist[i] = true;
            path.add(temp);
            backtrace(idx + 1, res, path, candidates, target - temp);
            vist[i] = false;
            path.remove(path.size() -1);
        }
    }
}
