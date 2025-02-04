/*
 * @Author: Tungbo
 * @Date: 2024-03-15 11:20:28
 * @LastEditTime: 2024-03-15 11:38:09
 * @LastEditors: Tungbo
 * @Description: leecode: 2312. 卖木头块
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240311;

public class Solution2312 {

    public long sellingWood(int m, int n, int[][] prices) {
        int[][] pr = new int[m + 1][n + 1];
        for (int[] p : prices) {
            pr[p[0]][p[1]] = p[2];
        }

        long[][] f = new long[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = pr[i][j];
                for (int k = 1; k < i; k++) {
                    f[i][j] = Math.max(f[i][j], f[i - k][j] + f[k][j]);
                }
                for (int k = 1; k < j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i][j - k] + f[i][k]);
                }
            }
        }
        return f[m][n];
    }

}
