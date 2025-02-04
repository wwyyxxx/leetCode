/*
 * @Author: Tungbo
 * @Date: 2022-06-10 11:28:28
 * @LastEditTime: 2022-06-10 12:30:59
 * @LastEditors: Tungbo
 * @Description: leecode: 730. 统计不同回文子序列
 * 
 * 给定一个字符串 s，返回 s 中不同的非空「回文子序列」个数 。
 * 通过从 s 中删除 0 个或多个字符来获得子序列。
 * 如果一个字符序列与它反转后的字符序列一致，那么它是「回文字符序列」。
 * 结果可能很大，你需要对 109 + 7 取模 。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220606;

public class Solution {

    public int countPalindromicSubsequences(String s) {
        int MOD = 1000000007;
        int n = s.length();
        int[][] dp = new int[n][n];
        //单字符是一个回文子序列
        for(int i = 0; i < n ; i++) {
            dp[i][i] = 1;
        }
        //从长度2的字串开始计算
        for (int len = 2; len <= n; len++) {
            //挨个计算长度为len的字串回文子序列个数
            for (int i = 0; i+len <= n; i++) {
                int j = i + len -1;
                // 1.相等
                if(s.charAt(i) == s.charAt(j)) {
                    int left = i + 1;
                    int right = j -1;
                    
                    while(left <= right && s.charAt(left) != s.charAt(i)) {
                        left++;
                    }

                    while(left <= right && s.charAt(right) != s.charAt(j)) {
                        right--;
                    }
                    if(left >right) {
                        dp[i][j] = 2 * dp[i+1][j-1] + 2;
                    } else if (left == right) {
                        //情况② 出现一个重复字符
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                    } else {
                        //情况③ 有两个及两个以上
                        dp[i][j] = 2 * dp[i + 1][j - 1] - dp[left + 1][right - 1];
                    }
                } else {
                    //情况(2) 不相等
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                }
                //处理超范围结果
                dp[i][j] = (dp[i][j] >= 0) ? dp[i][j] % MOD : dp[i][j] + MOD;
            }
        }
        return dp[0][n - 1];
    }
}
