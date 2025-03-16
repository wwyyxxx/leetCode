/*
 * @Author: Tungbo
 * @Date: 2025-03-16 21:19:44
 * @LastEditTime: 2025-03-16 21:20:52
 * @LastEditors: Tungbo
 * @Description: leecode: 2272. 最大波动的子字符串
 */
package practice.leetcode.src.wyx.leetcode2025.wyx0311;

public class Solution2272 {
    public int largestVariance(String s) {
        int n = s.length();
        int ans = 0;
        for (char a = 'a'; a <= 'z'; ++a) {
            for (char b = 'a'; b <= 'z'; ++b) {
                if (a == b) {
                    continue;
                }
                int[] f = new int[] {0, -n};
                for (int i = 0; i < n; ++i) {
                    if (s.charAt(i) == a) {
                        f[0]++;
                        f[1]++;
                    } else if (s.charAt(i) == b) {
                        f[1] = Math.max(f[0] - 1, f[1] - 1);
                        f[0] = 0;
                    }
                    ans = Math.max(ans, f[1]);
                }
            }
        }
        return ans;
    }
}
