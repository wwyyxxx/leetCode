/*
 * @Author: Tungbo
 * @Date: 2024-08-15 22:44:59
 * @LastEditTime: 2024-08-15 23:20:42
 * @LastEditors: Tungbo
 * @Description: leecode: 139.单词拆分
 */
package wyx.leetcode2024.wyx20240812;

import java.util.List;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int i = 0; i < dp.length; i++) {
            if (!dp[i]) {
                continue;
            }
            for(String word : wordDict) {
                if (word.length() + i <= s.length() && s.startsWith(word, i)) {
                    dp[i + word.length()] = true;
                }
            }
        }

        return dp[n];
    }

    
}
