/*
 * @Author: Tungbo
 * @Date: 2024-06-12 22:22:21
 * @LastEditTime: 2024-06-12 22:45:00
 * @LastEditors: Tungbo
 * @Description: leecode: 438. 找到字符串中所有字母异位词
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240610;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> dic = new HashMap<Character, Integer>();
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        for(Character c : p.toCharArray()) {
            dic.put(c, dic.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0, vaild = 0;
        List<Integer> result = new ArrayList<Integer>();
        while (r < s.length()) {
            char c = s.charAt(r++);
            if(dic.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(dic.get(c))) {
                    vaild++;
                }
            }

            while(r - l >= p.length()) {
                if(vaild == dic.size()) {
                    result.add(l);
                }
                char d = s.charAt(l++);
                if(dic.containsKey(d)) {
                    if (window.get(d).equals(dic.get(d))) {
                        vaild--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return result;
    }
}
