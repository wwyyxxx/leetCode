/*
 * @Author: Tungbo
 * @Date: 2023-03-13 10:19:26
 * @LastEditTime: 2023-03-14 12:47:05
 * @LastEditors: Tungbo
 * @Description: leecode: 1605. 给定行和列的和求可行矩阵
 */
package wyx.wyx20230313;

public class Solution1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length, m = colSum.length;
        int[][] ans = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
            }
        }
        return ans;
    }
}
