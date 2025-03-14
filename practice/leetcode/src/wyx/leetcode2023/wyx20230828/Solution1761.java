/*
 * @Author: Tungbo
 * @Date: 2023-08-31 23:27:40
 * @LastEditTime: 2023-08-31 23:27:44
 * @LastEditors: Tungbo
 * @Description: leecode: 1761. 一个图中连通三元组的最小度数
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230828;

public class Solution1761 {
    public int minTrioDegree(int n, int[][] edges) {
        int[][] g = new int[n][n];
        int[] degree = new int[n];

        for (int[] edge : edges) {
            int x = edge[0] - 1, y = edge[1] - 1;
            g[x][y] = g[y][x] = 1;
            ++degree[x];
            ++degree[y];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (g[i][j] == 1) {
                    for (int k = j + 1; k < n; ++k) {
                        if (g[i][k] == 1 && g[j][k] == 1) {
                            ans = Math.min(ans, degree[i] + degree[j] + degree[k] - 6);
                        }
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
