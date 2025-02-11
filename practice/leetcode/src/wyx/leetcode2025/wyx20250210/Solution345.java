package practice.leetcode.src.wyx.leetcode2025.wyx20250210;
/*
 * @Author: Tungbo
 * @Date: 2025-02-11 11:04:23
 * @LastEditTime: 2025-02-11 11:30:47
 * @LastEditors: Tungbo
 * @Description: leecode: 345. 反转字符串中的元音字母
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution345 {
    public String reverseVowels(String s) {
        Set<Character> dic = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chs = s.toCharArray();
        int l = 0, r = s.length() - 1;         
        while (l < r) {
            while (l < s.length() && !dic.contains(chs[l])) {
                l++;
            }
            while (r >= 0 && !dic.contains(chs[r])) {
                r--;
            }
            if(l >= r) break;
            char c= chs[l];
            chs[l++] = chs[r];
            chs[r--] = c;
        }
        return new String(chs);
    }
}
