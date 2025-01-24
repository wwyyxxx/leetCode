/*
 * @Author: Tungbo
 * @Date: 2025-01-25 00:51:02
 * @LastEditTime: 2025-01-25 00:51:17
 * @LastEditors: Tungbo
 * @Description: leecode: 2412. 完成所有交易的初始最少钱数
 */
package wyx.leetcode2024.wyx20250120;

public class Solution2412 {
    public long minimumMoney(int[][] transactions) {
        long totalLose = 0;
        int mx = 0;
        for (int i = 0; i < transactions.length; i++) {
            totalLose += Math.max(transactions[i][0] - transactions[i][1], 0);
            mx = Math.max(mx, Math.min(transactions[i][0], transactions[i][1]));
        }
        return totalLose + mx;
    }
}
