/*
 * @Author: Tungbo
 * @Date: 2023-03-27 22:22:44
 * @LastEditTime: 2023-03-27 22:54:48
 * @LastEditors: Tungbo
 * @Description: leecode: 1638. 统计只差一个字符的子串数目
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230327;

public class Solution1638 {
    public int countSubstrings(String s, String t) {
        int n = s.length(), m = t.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int diff = 0;
                for (int k = 0; i+k<n && j+k<n; k++) {
                    diff += s.charAt(i+k) == t.charAt(j+k) ? 0 : 1;
                    if(diff == 1) ans++;
                    else if(diff > 1) break;
                }
            }
        }
        return ans;
    }
}
