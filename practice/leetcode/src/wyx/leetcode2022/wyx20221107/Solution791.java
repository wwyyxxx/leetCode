/*
 * @Author: Tungbo
 * @Date: 2022-11-13 15:50:36
 * @LastEditTime: 2022-11-13 16:41:00
 * @LastEditors: Tungbo
 * @Description: leecode: 791. 自定义字符串排序
 * 
 * 给定两个字符串 order 和 s 。order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序
 * 对 s 的字符进行置换，使其与排序的 order 相匹配。
 * 更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 也应该出现在 y 之前
 * 返回 满足这个性质的 s 的任意排列 。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221107;

import java.util.Arrays;
import java.util.Comparator;

public class Solution791 {
    public String customSortString(String order, String s) {
        Character[] ans = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ans[i] = s.charAt(i);
        }
        int[] dic = new int[26];
        for (int i = 0; i < order.length(); i++) {
            dic[order.charAt(i) - 'a'] = i + 1;
        }
        Arrays.sort(ans, new Comparator<Character>() {
            @Override
            public int compare(Character arg0, Character arg1) {
                // return 1 交换位置 否则不换
                return dic[arg0 - 'a'] - dic[arg1 - 'a'];
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Character character : ans) {
            sb.append(character);
        }
        return sb.toString();
    }
}
