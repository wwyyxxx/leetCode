/*
 * @Author: Tungbo
 * @Date: 2023-11-07 11:51:44
 * @LastEditTime: 2023-11-07 11:51:46
 * @LastEditors: Tungbo
 * @Description: leecode: 2586. 统计范围内的元音字符串数
 */
package wyx.wyx20231106;

import java.util.HashSet;
import java.util.Set;

public class Solution2586 {
    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> dic = new HashSet<>();
        dic.add('a');dic.add('e');dic.add('i');dic.add('o');dic.add('u');
        int res = 0;
        for(int i = left; i <= right; i++) {
            char[] ch = words[i].toCharArray();
            if(dic.contains(ch[0]) && dic.contains(ch[ch.length - 1])) res++;
        }
        return res;
    }
}
