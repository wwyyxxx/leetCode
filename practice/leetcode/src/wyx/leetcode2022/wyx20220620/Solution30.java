/*
 * @Author: Tungbo
 * @Date: 2022-06-23 11:23:46
 * @LastEditTime: 2022-06-23 16:19:37
 * @LastEditors: Tungbo
 * @Description: leecode: 30. 串联所有单词的子串
 * 
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220620;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution30 {
    
    public static void main(String[] args) {
        System.out.println(new Solution30().findSubstring("barfoothefoobarman",new String[]{"foo","bar"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<Integer> res = new ArrayList<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        //记录每个词出现次数
        for(String word : words) {
            map.put(word,map.getOrDefault(word, 0)+1);
        }
        //滑动窗口遍历
        for (int i = 0; i < s.length() - all_len + 1; i++) {
            //截取数组中所有词的长度
            String temp = s.substring(i,i+all_len);
            //用于记录截取词的出现次数  因为每个词的长度一样
            HashMap<String, Integer> temp_map = new HashMap<>();
            for (int j = 0; j < all_len; j += one_word) {
                //记录截取词出现的次数  因为每个词的长度一样
                String temp_word = temp.substring(j,j+one_word);
                temp_map.put(temp_word,temp_map.getOrDefault(temp_word,0)+1);
            }
            //比较
            if(map.equals(temp_map)) res.add(i);
        }
        return res;
    }


    //没办法处理 "barfoofoobarthefoobarman", words = ["bar","foo","the"]
    public List<Integer> findSubstring1(String s, String[] words) {
        int[] sc = new int[26];
        int[] wc = new int[26];
        List<Integer> res = new ArrayList<>();
        int n = 0;
        for(String word : words) {
            for(int i = 0; i < word.length(); i++) {
                wc[word.charAt(i) - 'a']++;
                n++;
            }
        }
        int l = 0, r = 0;
        for(; r < n; r++) {
            sc[s.charAt(r) - 'a']++;
        }
        if(Arrays.equals(sc,wc)) {
            res.add(r-n);
        }

        for (; r < s.length(); r++) {
            sc[s.charAt(r) - 'a']++;
            sc[s.charAt(r-n) - 'a']--;
            if(Arrays.equals(sc,wc)) {
                res.add(r-n+1);
            }
        }
        return res;
    }

}
