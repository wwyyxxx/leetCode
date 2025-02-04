/*
 * @Author: Tungbo
 * @Date: 2022-11-11 14:49:02
 * @LastEditTime: 2022-11-11 14:57:08
 * @LastEditors: Tungbo
 * @Description: leecode: 1704. 判断字符串的两半是否相似
 * 
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）
 * 注意，s 可能同时含有大写和小写字母
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221107;

import java.util.HashSet;
import java.util.Set;

public class Solution1704 {

    char[] dic = new char[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };

    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<Character>();
        for (char c : dic) {
            set.add(c);
        }
        int n = s.length();
        int l = 0, r = 0;
        for (int i = 0; i < n / 2; i++) {
            if (set.contains(s.charAt(i)))
                l++;
            if (set.contains(s.charAt(n - i - 1)))
                r++;
        }
        return l == r;
    }

}
