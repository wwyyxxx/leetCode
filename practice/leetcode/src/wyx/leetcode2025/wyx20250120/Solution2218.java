/*
 * @Author: Tungbo
 * @Date: 2025-01-21 14:08:02
 * @LastEditTime: 2025-01-21 14:12:36
 * @LastEditors: Tungbo
 * @Description: leecode: 2218. 从栈中取出 K 个硬币的最大面值和
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250120;

import java.util.List;

public class Solution2218 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] memo = new int[n][k+1];
        return dfs(n-1, k, piles, memo);
    }
        
    private int dfs(int i, int j, List<List<Integer>> piles, int[][] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int res = dfs(i - 1, j, piles, memo);

        int v = 0;
        for (int w = 0; w < Math.min(j, piles.get(i).size()); w++) {
            v += piles.get(i).get(w);
            res = Math.max(res, dfs(i - 1, j - w -1, piles, memo) + v);
        }
        return memo[i][j] = res;
    }
}
