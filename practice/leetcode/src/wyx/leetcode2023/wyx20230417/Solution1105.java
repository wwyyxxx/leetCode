/*
 * @Author: Tungbo
 * @Date: 2023-04-23 17:23:26
 * @LastEditTime: 2023-04-23 17:24:32
 * @LastEditors: Tungbo
 * @Description: leecode: 1105. 填充书架
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230417;

import java.util.Arrays;

public class Solution1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
            int maxHeight = 0, curWidth = 0;
            for (int j = i; j >= 0; --j) {
                curWidth += books[j][0];
                if (curWidth > shelfWidth) {
                    break;
                }
                maxHeight = Math.max(maxHeight, books[j][1]);
                dp[i + 1] = Math.min(dp[i + 1], dp[j] + maxHeight);
            }
        }
        return dp[n];
    }
}
