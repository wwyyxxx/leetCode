package wyx.leetcode2024.wyx20250106;

import java.util.Arrays;

/*
 * @Author: Tungbo
 * @Date: 2025-01-12 00:18:33
 * @LastEditTime: 2025-01-12 00:28:00
 * @LastEditors: Tungbo
 * @Description: leecode: 2275. 按位与结果大于零的最长组合
 */
public class Solution2275 {
    public int largestCombination(int[] candidates) {
        int[] cnt = new int[24];
        for (int i = 0; i < candidates.length; i++) {
            int candidate = candidates[i];
            for (int j = 0; candidate > 0; j++) {
                cnt[j] += candidate & 1;
                candidate >>= 1;
            }
        }
        return Arrays.stream(cnt).max().getAsInt();
    }
}
