/*
 * @Author: Tungbo
 * @Date: 2023-08-29 19:06:42
 * @LastEditTime: 2023-08-29 19:45:09
 * @LastEditors: Tungbo
 * @Description: leecode: 823. 带因子的二叉树
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230828;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution823 {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = (int) (1e9 + 7);
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            map.put(arr[i],i);
        }
        long[] memo = new long[n];
        Arrays.fill(memo, -1);
        long res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res += dfs(i, arr, map,memo);
        }
        return (int) (res % MOD);
    }

    private long dfs(int idx, int[] arr, Map<Integer, Integer> map, long[] memo) {
        if(memo[idx] != -1) return memo[idx];

        long res = 1;
        int value = arr[idx];
        for (int i = idx; i >= 0; i--) {
            if(value % arr[i] != 0 || !map.containsKey(value / arr[i])) continue;

            res += dfs(map.get(value / arr[i]), arr, map, memo) * dfs(i, arr, map, memo);
        }
        return memo[idx] = res;
    }
}
