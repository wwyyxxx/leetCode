/*
 * @Author: Tungbo
 * @Date: 2022-12-22 18:31:11
 * @LastEditTime: 2022-12-22 18:31:13
 * @LastEditors: Tungbo
 * @Description: leecode: 1799. N 次操作后的最大分数和
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221219;

public class Solution1799 {
    public int maxScore(int[] nums) {
        int m = nums.length;
        int[][] g = new int[m][m];
        for (int i = 0; i < m; ++i) {
            for (int j = i + 1; j < m; ++j) {
                g[i][j] = gcd(nums[i], nums[j]);
            }
        }
        int[] f = new int[1 << m];
        for (int k = 0; k < 1 << m; ++k) {
            int cnt = Integer.bitCount(k);
            if (cnt % 2 == 0) {
                for (int i = 0; i < m; ++i) {
                    if (((k >> i) & 1) == 1) {
                        for (int j = i + 1; j < m; ++j) {
                            if (((k >> j) & 1) == 1) {
                                f[k] = Math.max(f[k], f[k ^ (1 << i) ^ (1 << j)] + cnt / 2 * g[i][j]);
                            }
                        }
                    }
                }
            }
        }
        return f[(1 << m) - 1];
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
