/*
 * @Author: Tungbo
 * @Date: 2022-11-08 10:42:46
 * @LastEditTime: 2022-11-08 10:51:27
 * @LastEditors: Tungbo
 * @Description: leecode: 1684. 统计一致字符串的数目
 * 
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。
 * 如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 
 * 请你返回 words 数组中 一致字符串 的数目。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221107;

import java.util.HashSet;
import java.util.Set;

public class Solution1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> dic = new HashSet<Character>();
        for (Character character : allowed.toCharArray()) {
            dic.add(character);
        }

        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            for (Character character : words[i].toCharArray()) {
                if (!dic.contains(character)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                ans++;
        }
        return ans;
    }
}
