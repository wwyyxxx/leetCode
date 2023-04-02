/*
 * @Author: Tungbo
 * @Date: 2023-04-02 22:14:37
 * @LastEditTime: 2023-04-02 22:20:09
 * @LastEditors: Tungbo
 * @Description: leecode: 1039. 多边形三角剖分的最低得分
 */
package wyx.wyx20230327;

import java.util.Arrays;

public class Solution1039 {

    private int[] v;
    private int[][] memo;

    public int minScoreTriangulation(int[] values) {
        v = values;
        int n = v.length;
        memo = new int[n][n];
        for (int i = 0; i < n; ++i)
            Arrays.fill(memo[i], -1); // -1 表示没有访问过
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i + 1 == j) return 0; // 只有两个点，无法组成三角形
        if (memo[i][j] != -1) return memo[i][j];
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; ++k) // 枚举顶点 k
            res = Math.min(res, dfs(i, k) + dfs(k, j) + v[i] * v[j] * v[k]);
        return memo[i][j] = res;
    }
}
