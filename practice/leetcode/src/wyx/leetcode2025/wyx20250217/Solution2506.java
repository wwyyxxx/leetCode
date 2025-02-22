/*
 * @Author: Tungbo
 * @Date: 2025-02-22 11:49:52
 * @LastEditTime: 2025-02-22 12:06:28
 * @LastEditors: Tungbo
 * @Description: leecode: 2506. 统计相似字符串对的数目
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250217;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2506 {
    public int similarPairs(String[] words) {
        List<char[]> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            char[] ch = new char[26];
            Arrays.fill(ch, '0');
            for (char word : words[i].toCharArray()) {
                ch[word - 'a'] = '1';
            }
            System.out.println(Arrays.toString(ch));
            list.add(ch);
        }
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (equalsList(list.get(i), list.get(j))) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean equalsList(char[] cs, char[] cs2) {
        if (cs.length != cs2.length) {
            return false;
        }
        for (int i = 0; i < cs2.length; i++) {
            if(cs[i] != cs2[i]) return false; 
        }
        return true;
    }
}
