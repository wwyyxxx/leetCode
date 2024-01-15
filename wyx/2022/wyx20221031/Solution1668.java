/*
 * @Author: Tungbo
 * @Date: 2022-11-03 10:43:54
 * @LastEditTime: 2022-11-03 11:01:50
 * @LastEditors: Tungbo
 * @Description: leecode: 1668. 最大重复子字符串
 * 
 * 给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为 k 。
 * 单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 为 0
 * 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 
 * 
 */
package wyx.wyx20221031;

public class Solution1668 {
    public int maxRepeating(String sequence, String word) {
        StringBuilder sb = new StringBuilder(word);
        int i = 1;
        int ans = 0;
        while(sb.length() <= sequence.length()) {
            if(sequence.contains(sb)) ans = Math.max(ans,i);
            sb.append(word);
            i++;
        }
        return ans;
    }
}
