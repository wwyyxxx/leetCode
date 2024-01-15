/*
 * @Author: Tungbo
 * @Date: 2023-04-22 14:24:22
 * @LastEditTime: 2023-04-22 14:24:26
 * @LastEditors: Tungbo
 * @Description: leecode: 1027. 最长等差数列
 */
package wyx.wyx20230417;

import java.util.HashMap;
import java.util.Map;

public class Solution1027 {
    private Map<Integer, Integer>[] maxLen;
    private int[] a;
    private int ans;

    public int longestArithSeqLength(int[] nums) {
        a = nums;
        int n = a.length;
        maxLen = new HashMap[n];
        for (int i = 1; i < n; ++i)
            dfs(i);
        return ans;
    }

    private Map<Integer, Integer> dfs(int i) {
        if (maxLen[i] != null) return maxLen[i]; // 之前算过了
        // i=0 时不会进入循环
        maxLen[i] = new HashMap<>();
        for (int j = i - 1; j >= 0; --j) {
            int d = a[i] - a[j]; // 公差
            if (!maxLen[i].containsKey(d)) {
                maxLen[i].put(d, dfs(j).getOrDefault(d, 1) + 1);
                ans = Math.max(ans, maxLen[i].get(d));
            }
        }
        return maxLen[i];
    }
}
