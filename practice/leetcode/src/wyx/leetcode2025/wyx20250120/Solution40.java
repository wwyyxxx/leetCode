/*
 * @Author: Tungbo
 * @Date: 2025-01-26 22:53:40
 * @LastEditTime: 2025-01-26 23:59:27
 * @LastEditors: Tungbo
 * @Description: leecode: 40. 组合总和 II
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(candidates);
        backtrace(0, res, new ArrayList<Integer>(), candidates, target);
        return new ArrayList<>(res);
    }

    private void backtrace(int idx , Set<List<Integer>> res, List<Integer> path, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = idx; i < candidates.length; i++) {
            if(candidates[i] - target > 0) break;
            if (i > idx && candidates[i] == candidates[i-1]) {
                continue;
            }
            int temp = candidates[i];
            path.add(temp);
            backtrace(i + 1, res, path, candidates, target - temp);
            path.remove(path.size() -1);
        }
    }
}
