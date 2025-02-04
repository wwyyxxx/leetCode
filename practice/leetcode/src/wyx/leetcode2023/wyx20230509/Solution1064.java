/*
 * @Author: Tungbo
 * @Date: 2023-05-14 15:18:02
 * @LastEditTime: 2023-05-14 15:35:42
 * @LastEditors: Tungbo
 * @Description: leecode: 1054. 距离相等的条形码
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230509;

import java.util.Arrays;

public class Solution1064 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        Integer[] t = new Integer[n];
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            t[i] = barcodes[i];
            mx = Math.max(mx, barcodes[i]);
        }
        int[] cnt = new int[mx + 1];
        for (int x : barcodes) {
            ++cnt[x];
        }
        Arrays.sort(t, (a, b) -> cnt[a] == cnt[b] ? a - b : cnt[b] - cnt[a]);
        int[] ans = new int[n];
        for (int k = 0, j = 0; k < 2; ++k) {
            for (int i = k; i < n; i += 2) {
                ans[i] = t[j++];
            }
        }
        return ans;
    }
}
