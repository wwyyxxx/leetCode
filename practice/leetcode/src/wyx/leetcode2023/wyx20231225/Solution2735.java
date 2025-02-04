/*
 * @Author: Tungbo
 * @Date: 2023-12-28 15:49:58
 * @LastEditTime: 2023-12-28 15:50:01
 * @LastEditors: Tungbo
 * @Description: leecode: 2735. 收集巧克力
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20231225;

public class Solution2735 {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; ++i) {
            f[i][0] = nums[i];
            for (int j = 1; j < n; ++j) {
                f[i][j] = Math.min(f[i][j - 1], nums[(i - j + n) % n]);
            }
        }
        long ans = 1L << 60;
        for (int j = 0; j < n; ++j) {
            long cost = 1L * x * j;
            for (int i = 0; i < n; ++i) {
                cost += f[i][j];
            }
            ans = Math.min(ans, cost);
        }
        return ans;
    }
}
