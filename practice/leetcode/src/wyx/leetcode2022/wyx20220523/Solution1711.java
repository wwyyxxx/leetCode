package practice.leetcode.src.wyx.leetcode2022.wyx20220523;

/*
 * @Author: Tungbo
 * @Date: 2022-05-26 16:45:20
 * @LastEditTime: 2022-05-27 22:37:06
 * @LastEditors: Tungbo
 * @Description: leecode: 面试题 17.11. 单词距离
 * 
 * 有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
 * 如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 * 
 */
public class Solution1711 {

    public int findClosest(String[] words, String word1, String word2) {
        //记录返回的最大值
        int ans = Integer.MAX_VALUE;
        //初始化差值最大
        int word1Idx = Integer.MAX_VALUE;
        int word2Idx = -Integer.MIN_VALUE;

        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            //每次匹配上都去比较距离大小
            if(word.equals(word1)) {
                word1Idx = i;
                ans = Math.min(Math.abs(word1Idx - word2Idx), ans);
            } else if(word.equals(word2)){
                word2Idx = i;
                ans = Math.min(Math.abs(word1Idx - word2Idx), ans);
            }
        }
        return ans;
    }

}