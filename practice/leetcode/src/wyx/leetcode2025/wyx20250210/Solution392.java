/*
 * @Author: Tungbo
 * @Date: 2025-02-14 23:24:33
 * @LastEditTime: 2025-02-14 23:24:38
 * @LastEditors: Tungbo
 * @Description: leecode: 392. 判断子序列
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250210;

public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i >= s.length();
    }
}
