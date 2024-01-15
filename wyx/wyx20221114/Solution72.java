/*
 * @Author: Tungbo
 * @Date: 2022-11-14 11:17:00
 * @LastEditTime: 2022-11-14 11:27:49
 * @LastEditors: Tungbo
 * @Description: leecode: 72. 编辑距离
 * 
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  
 * 你可以对一个单词进行如下三种操作：
 *  插入一个字符
 *  删除一个字符
 *  替换一个字符
 * 
 */
package wyx.wyx20221114;

public class Solution72 {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= n2; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
            }
        }
        return dp[n1][n2];
    }
}
