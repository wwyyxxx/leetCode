/*
 * @Author: Tungbo
 * @Date: 2022-08-06 17:36:02
 * @LastEditTime: 2022-08-06 17:44:05
 * @LastEditors: Tungbo
 * @Description: leecode: 1408. 数组中的字符串匹配
 * 
 * 给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词
 * 如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串
 * 
 */
package wyx.wyx20220801;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if(i==j || words[i].length() > words[j].length()) continue;
                if(words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
}
