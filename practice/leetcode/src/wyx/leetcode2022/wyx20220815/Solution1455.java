/*
 * @Author: Tungbo
 * @Date: 2022-08-21 15:59:16
 * @LastEditTime: 2022-08-21 16:18:48
 * @LastEditors: Tungbo
 * @Description: leecode: 1455. 检查单词是否为句中其他单词的前缀
 * 
 * 给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀
 * 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。如果 searchWord 不是任何单词的前缀，则返回 -1
 * 字符串 s 的 前缀 是 s 的任何前导连续子字符串
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220815;

public class Solution1455 {
    
    public int isPrefixOfWord(String sentence, String searchWord) {
        int ans = -1;
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if(words[i].indexOf(searchWord) == 1) {
                return i;
            }
        }
        return ans;
    }

}
