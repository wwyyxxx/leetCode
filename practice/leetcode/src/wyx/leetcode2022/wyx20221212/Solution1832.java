package practice.leetcode.src.wyx.leetcode2022.wyx20221212;

/*
 * @Author: Tungbo
 * @Date: 2022-12-13 14:16:55
 * @LastEditTime: 2022-12-13 14:16:57
 * @LastEditors: Tungbo
 * @Description: leecode: 1832. 判断句子是否为全字母句
 * 
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 * 如果是，返回 true ；否则，返回 false 。
 * 
 */
public class Solution1832 {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26) return false;
        int[] dic = new int[26];
        for(int i =0; i< sentence.length();i++) {
            dic[sentence.charAt(i) - 'a']++;
        }
        for(int i = 0; i<26;i++) {
            if(dic[i] == 0) return false;
        }
        return true;
    }
}
