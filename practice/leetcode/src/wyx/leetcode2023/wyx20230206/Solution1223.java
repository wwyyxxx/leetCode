/*
 * @Author: Tungbo
 * @Date: 2023-02-10 12:04:45
 * @LastEditTime: 2023-02-10 12:27:10
 * @LastEditors: Tungbo
 * @Description: leecode: 1223. 掷骰子模拟
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230206;

public class Solution1223 {
    static final int MOD = 1000000007;

    public int dieSimulator(int n, int[] rollMax) {
        int[][][] d = new int[n + 1][6][16];
        for (int j = 0; j < 6; j++) {
            d[1][j][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 1; k <= rollMax[j]; k++) {
                    for (int p = 0; p < 6; p++) {
                        if (p != j) {
                            d[i][p][1] = (d[i][p][1] + d[i - 1][j][k]) % MOD;
                        } else if (k + 1 <= rollMax[j]) {
                            d[i][p][k + 1] = (d[i][p][k + 1] + d[i - 1][j][k]) % MOD;
                        }
                    }
                }
            }
        }
        
        int res = 0;
        for (int j = 0; j < 6; j++) {
            for (int k = 1; k <= rollMax[j]; k++) {
                res = (res + d[n][j][k]) % MOD;
            }
        }
        return res;
    }
}
