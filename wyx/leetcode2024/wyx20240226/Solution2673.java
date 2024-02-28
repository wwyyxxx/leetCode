/*
 * @Author: Tungbo
 * @Date: 2024-02-28 14:24:38
 * @LastEditTime: 2024-02-28 15:13:31
 * @LastEditors: Tungbo
 * @Description: leecode: 2673. 使二叉树所有路径值相等的最小代价
 */
package wyx.leetcode2024.wyx20240226;

public class Solution2673 {
    public int minIncrements(int n, int[] cost) {
        // 1 2 3 4 5 6 7
        // 0 1 2 3 4 5 6
        int res = 0;
        for (int i = n / 2; i > 0; i--) {
            res += Math.abs(cost[i * 2 - 1] - cost[i * 2]);
            cost[i - 1] += Math.max(cost[i * 2 - 1], cost[i * 2]);
        }
        return res;
    }
}
