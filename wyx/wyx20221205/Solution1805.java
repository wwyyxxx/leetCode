/*
 * @Author: Tungbo
 * @Date: 2022-12-06 18:31:14
 * @LastEditTime: 2022-12-06 18:58:50
 * @LastEditors: Tungbo
 * @Description: leecode: 1805. 字符串中不同整数的数目
 * 
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。
 * 注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 * 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
 * 
 */
package wyx.wyx20221205;

import java.util.HashSet;
import java.util.Set;

public class Solution1805 {
    public int numDifferentIntegers(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isDigit(chars[i])) {
                chars[i] = ' ';
            }
        }
        String[] s = new String(chars).trim().split(" ");
        Set<String> set = new HashSet<String>();
        for (String str : s) {
            if (str.length() == 0)
                continue;
            int i = 0;
            while (i < str.length() - 1 && str.charAt(i) == '0') {
                i++;
            }
            set.add(str.substring(i));
        }
        return set.size();
    }
}
