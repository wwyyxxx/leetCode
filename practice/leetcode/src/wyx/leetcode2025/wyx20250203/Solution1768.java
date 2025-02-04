/*
 * @Author: Tungbo
 * @Date: 2025-02-04 17:32:28
 * @LastEditTime: 2025-02-04 17:32:45
 * @LastEditors: Tungbo
 * @Description: leecode: 1768. 交替合并字符串
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250203;

public class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int w1 = 0, w2 = 0;
        while (w1 < word1.length() && w2 < word2.length()) {
            sb.append(word1.charAt(w1++));
            sb.append(word2.charAt(w2++));
        }
        if (w1 < word1.length()) {
            sb.append(word1.substring(w1));
        }
        if (w2 < word2.length()) {
            sb.append(word2.substring(w2));
        }
        return sb.toString();
    }
}
