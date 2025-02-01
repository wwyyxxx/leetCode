/*
 * @Author: Tungbo
 * @Date: 2025-02-02 00:30:21
 * @LastEditTime: 2025-02-02 00:40:09
 * @LastEditors: Tungbo
 * @Description: leecode: 598. 区间加法 II
 */
package wyx.leetcode2024.wyx20250128;

import java.util.Arrays;

public class Solution598 {
    public int maxCount(int m, int n, int[][] ops) {
        int mina = m, minb = n;
        for(int[] op : ops) {
            mina = Math.min(mina, op[0]);
            minb = Math.min(minb, op[1]);
        }
        return mina * minb;
    }
}
