/*
 * @Author: Tungbo
 * @Date: 2024-09-21 19:58:32
 * @LastEditTime: 2024-09-21 20:11:17
 * @LastEditors: Tungbo
 * @Description: leecode: 最长有效括号
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240916;

public class Solution32 {
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') continue;
            if(s.charAt(i - 1) == '(') {
                dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            } else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;;
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }   
}
