/*
 * @Author: Tungbo
 * @Date: 2025-03-08 12:41:57
 * @LastEditTime: 2025-03-08 12:42:02
 * @LastEditors: Tungbo
 * @Description: leecode: 1657. 确定两个字符串是否接近
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250303;

import java.util.Arrays;

public class Solution1657 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] word1Cnt = new int[26];
        for (char c : word1.toCharArray()) {
            word1Cnt[c - 'a']++;
        }

        int[] word2Cnt = new int[26];
        for (char c : word2.toCharArray()) {
            word2Cnt[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((word1Cnt[i] == 0) != (word2Cnt[i] == 0)) {
                return false;
            }
        }
        
        Arrays.sort(word1Cnt);
        Arrays.sort(word2Cnt);
        return Arrays.equals(word1Cnt, word2Cnt);
    }
}
