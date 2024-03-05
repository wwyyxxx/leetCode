/*
 * @Author: Tungbo
 * @Date: 2024-03-05 11:41:15
 * @LastEditTime: 2024-03-05 11:41:17
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
package wyx.leetcode2024.wyx20240304;

import java.util.Arrays;

public class Solution1976 {
    public int countPaths(int n, int[][] roads) {
        long[][] g = new long[n][n]; // 邻接矩阵
        for (long[] row : g) {
            Arrays.fill(row, Long.MAX_VALUE / 2); // 防止溢出
        }
        for (int[] r : roads) {
            int x = r[0];
            int y = r[1];
            int d = r[2];
            g[x][y] = d;
            g[y][x] = d;
        }

        long[] dis = new long[n];
        Arrays.fill(dis, 1, n, Long.MAX_VALUE / 2);
        int[] f = new int[n];
        f[0] = 1;
        boolean[] done = new boolean[n];
        while (true) {
            int x = -1;
            for (int i = 0; i < n; i++) {
                if (!done[i] && (x < 0 || dis[i] < dis[x])) {
                    x = i;
                }
            }
            if (x == n - 1) {
                // 不可能找到比 dis[n-1] 更短，或者一样短的最短路了（注意本题边权都是正数）
                return f[n - 1];
            }
            done[x] = true; // 最短路长度已确定（无法变得更小）
            for (int y = 0; y < n; y++) { // 尝试更新 x 的邻居的最短路
                long newDis = dis[x] + g[x][y];
                if (newDis < dis[y]) {
                    // 就目前来说，最短路必须经过 x
                    dis[y] = newDis;
                    f[y] = f[x];
                } else if (newDis == dis[y]) {
                    // 和之前求的最短路一样长
                    f[y] = (f[y] + f[x]) % 1_000_000_007;
                }
            }
        }
    }
}
