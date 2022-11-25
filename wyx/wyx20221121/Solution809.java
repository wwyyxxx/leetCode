/*
 * @Author: Tungbo
 * @Date: 2022-11-25 11:27:04
 * @LastEditTime: 2022-11-25 12:21:26
 * @LastEditors: Tungbo
 * @Description: leecode: 809. 情感丰富的文字
 * 
 * 有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。
 * 我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。
 * 选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。
 * 输入一组查询单词，输出其中可扩张的单词数量。
 * 
 */
package wyx.wyx20221121;

import java.util.Arrays;

public class Solution809 {

    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (check(word, s))
                ans++;
        }
        return ans;
    }

    private boolean check(String word, String s) {
        int sl = s.length();
        int wl = word.length();
        int wi = 0, si = 0;
        while (wi < wl && si < sl) {
            if (word.charAt(wi) != s.charAt(si)) {
                return false;
            }
            char ch = s.charAt(si);
            int cnts = 0;
            while (si < sl && s.charAt(si) == ch) {
                si++;
                cnts++;
            }
            int cntw = 0;
            while (wi < wl && word.charAt(wi) == ch) {
                wi++;
                cntw++;
            }
            if (cntw > cnts)
                return false;
            if (cntw != cnts && cnts < 3)
                return false;
        }
        return wi == wl && si == sl;
    }

    public int expressiveWords1(String s, String[] words) {
        // 24/34
        // "sass"
        // ["sa"]
        int[] dic = new int[26];
        int ans = 0;
        for (char i : s.toCharArray()) {
            dic[i - 'a']++;
        }
        for (String w : words) {
            int[] word = new int[26];
            for (char i : w.toCharArray()) {
                word[i - 'a']++;
            }
            for (int i = 0; i < word.length; i++) {
                if (dic[i] >= 3 && word[i] > 0 && word[i] < dic[i])
                    word[i] = dic[i];
            }
            if (Arrays.equals(word, dic))
                ans++;
        }
        return ans;
    }
}
