package practice.leetcode.src.wyx.leetcode2023.wyx20231231;
/*
 * @Author: Tungbo
 * @Date: 2024-01-04 16:04:40
 * @LastEditTime: 2024-01-04 16:05:51
 * @LastEditors: Tungbo
 * @Description: leecode: 2397. 被列覆盖的最多行数
 */
public class Solution2397 {
    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length, n = matrix[0].length;
        int[] rows = new int[m];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    rows[i] |= 1 << j;
                }
            }
        }
        int ans = 0;
        for (int mask = 1; mask < 1 << n; ++mask) {
            if (Integer.bitCount(mask) != numSelect) {
                continue;
            }
            int t = 0;
            for (int x : rows) {
                if ((x & mask) == x) {
                    ++t;
                }
            }
            ans = Math.max(ans, t);
        }
        return ans;
    }
}
