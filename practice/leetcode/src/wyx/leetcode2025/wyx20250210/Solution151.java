/*
 * @Author: Tungbo
 * @Date: 2025-02-12 12:03:31
 * @LastEditTime: 2025-02-12 12:09:13
 * @LastEditors: Tungbo
 * @Description: leecode: 151. 反转字符串中的单词
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250210;

public class Solution151 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int l = 0, r = words.length - 1;
        while (l < r) {
            while (l < r && ("").equals(words[l])) {
                l++;
            }
            while (l < r && ("").equals(words[r])) {
                r--;
            }
            String temp = words[l];
            words[l] = words[r];
            words[r] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("")) {
                continue;
            }
            sb.append(words[i].trim());
        }
        return sb.toString().trim();
    }
}
