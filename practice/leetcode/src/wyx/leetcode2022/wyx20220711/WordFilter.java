/*
 * @Author: Tungbo
 * @Date: 2022-07-14 18:03:11
 * @LastEditTime: 2022-07-14 19:20:07
 * @LastEditors: Tungbo
 * @Description: leecode: 745. 前缀和后缀搜索
 * 
 * 设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。
 * 实现 WordFilter 类：
 *     WordFilter(string[] words) 使用词典中的单词 words 初始化对象。
 *     f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，返回其中 最大的下标 。如果不存在这样的单词，返回 -1
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220711;

public class WordFilter {
    
    String[] words;

    public WordFilter(String[] words) {
        this.words = words;
    }
    
    public int f(String pref, String suff) {
        for (int i = words.length -1; i <= 0; i--) {
            // if(words[i].indexOf(pref) == 0 && words[i].lastIndexOf(suff) == words[i].length() - suff.length()) {
            //     return i;
            // }
            if(words[i].startsWith(pref)&& words[i].endsWith(suff)) {
                return i;
            }
        }
        return -1;
    }

}
