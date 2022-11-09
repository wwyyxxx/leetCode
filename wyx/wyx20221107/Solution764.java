package wyx.wyx20221107;

import java.util.Arrays;

/*
 * @Author: Tungbo
 * @Date: 2022-11-09 15:08:26
 * @LastEditTime: 2022-11-09 15:56:45
 * @LastEditors: Tungbo
 * @Description: leecode: 764. 最大加号标志
 * 
 * 在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。
 * mines[i] = [xi, yi]表示 grid[xi][yi] == 0
 * 返回  grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 
 * 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。
 * 注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。
 * 
 */
public class Solution764 {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int ans = 0;
        int[][] g = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(g[i], 1);
        }
        for (int i = 0; i < mines.length; i++) {
            g[mines[i][0] + 1][mines[i][1] + 1] = 0;
        }
        int[][] a = new int[n + 2][n + 2], b = new int[n + 2][n + 2], c = new int[n + 2][n + 2],
                d = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (g[i][j] == 1) {
                    a[i][j] = a[i - 1][j] + 1;
                    b[i][j] = b[i][j - 1] + 1;
                }
                if (g[n + 1 - i][n + 1 - j] == 1) {
                    c[n + 1 - i][n + 1 - j] = c[n + 2 - i][n + 1 - j] + 1;
                    d[n + 1 - i][n + 1 - j] = d[n + 1 - i][n + 2 - j] + 1;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ans = Math.max(ans, Math.min(Math.min(a[i][j], b[i][j]), Math.min(c[i][j], d[i][j])));
            }
        }
        return ans;
    }
}
