/*
 * @Author: Tungbo
 * @Date: 2022-11-17 12:06:40
 * @LastEditTime: 2022-11-17 13:38:25
 * @LastEditors: Tungbo
 * @Description: leecode: 792. 匹配子序列的单词数
 * 
 * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序
 * 例如， “ace” 是 “abcde” 的子序列。
 * 
 */
package wyx.wyx20221114;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution792 {
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        LinkedList<String>[] d = new LinkedList[26];
        for (int i = 0; i < 26; i++) {
            d[i] = new LinkedList<>();
        }

        for (String word : words) {
            d[word.charAt(0) - 'a'].add(word);
        }

        for (int i = 0; i < s.length(); i++) {
            LinkedList<String> l = d[s.charAt(i) - 'a'];
            for (int j = l.size(); j > 0; j--) {
                String word = l.pollFirst();
                if (word.length() == 1) {
                    ans++;
                } else {
                    d[word.charAt(1) - 'a'].offer(word.substring(1));
                }
            }
        }
        return ans;
    }
}
