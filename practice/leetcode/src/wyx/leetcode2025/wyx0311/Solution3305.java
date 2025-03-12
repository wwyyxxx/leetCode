/*
 * @Author: Tungbo
 * @Date: 2025-03-12 21:51:48
 * @LastEditTime: 2025-03-12 22:14:34
 * @LastEditors: Tungbo
 * @Description: leecode: 3306. 元音辅音字符串计数 II
 */
package practice.leetcode.src.wyx.leetcode2025.wyx0311;

import java.util.HashSet;
import java.util.Set;

public class Solution3305 {
    public int countOfSubstrings(String word, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int n = word.length();
        int res = 0;

        for (int i = 0; i < n; i++) {
            Set<Character> occurs = new HashSet<>();
            int consonants = 0;
            for (int j = i; j < n; j++) {
                if (vowels.contains(word.charAt(j))) {
                    occurs.add(word.charAt(j));
                } else {
                    consonants++;
                }
                if (occurs.size() == 5 && consonants == k) {
                    res++;
                }
            }
        }
        return res;

    }
}
