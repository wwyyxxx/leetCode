package practice.leetcode.src.wyx.leetcode2025.wyx20250217;

import java.util.Arrays;

/*
 * @Author: Tungbo
 * @Date: 2025-02-21 10:41:39
 * @LastEditTime: 2025-02-21 10:45:04
 * @LastEditors: Tungbo
 * @Description: leecode: 2209. 用地毯覆盖后的最少白色砖块
 */
public class Solution2209 {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int m = floor.length();
        int[][] memo = new int[numCarpets + 1][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(numCarpets, m - 1, floor.toCharArray(), memo, carpetLen);
    }

    private int dfs(int i, int j, char[] floor, int[][] memo, int carpetLen) {
        if (j < carpetLen * i) { // 剩余砖块可以全部覆盖
            return 0;
        }
        if (memo[i][j] != -1) { // 之前计算过
            return memo[i][j];
        }
        int res = dfs(i, j - 1, floor, memo, carpetLen) + (floor[j] - '0');
        if (i > 0) {
            res = Math.min(res, dfs(i - 1, j - carpetLen, floor, memo, carpetLen));
        }
        return memo[i][j] = res; // 记忆化
    }
}
