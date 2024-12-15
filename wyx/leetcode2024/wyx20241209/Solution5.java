package wyx.leetcode2024.wyx20241209;

/*
 * @Author: Tungbo
 * @Date: 2024-12-15 17:19:49
 * @LastEditTime: 2024-12-15 17:42:51
 * @LastEditors: Tungbo
 * @Description: leecode: 最长回文子串
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        int begin = 0, maxLen = 1;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i < len; i++) {
                int j =  i + l -1;
                if (j >= len) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else { 
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if(dp[i][j] && maxLen < j - i + 1) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
