/*
 * @Author: Tungbo
 * @Date: 2025-01-22 21:38:56
 * @LastEditTime: 2025-01-22 21:49:31
 * @LastEditors: Tungbo
 * @Description: leecode: 1561. 你可以获得的最大硬币数目
 */
package wyx.leetcode2024.wyx20250120;

import java.util.Arrays;

public class Solution1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int res = 0;
        for (int i = piles.length - 2, j = 0; i > j; i-=2, j++) {
            res += piles[i];
        }
        return res;
    }
}
