/*
 * @Author: Tungbo
 * @Date: 2024-07-07 16:06:19
 * @LastEditTime: 2024-07-07 16:42:00
 * @LastEditors: Tungbo
 * @Description: leecode: 76. 最小覆盖子串
 */
package wyx.leetcode2024.wyx20240701;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution76 {

    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();
    
    public String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if(tLen > sLen) return "";
        
        for(Character c : t.toCharArray()) {
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = -1;
        int len = Integer.MAX_VALUE;
        int ansL = -1, ansR = -1;
        while (r < sLen) {
            ++r;
            if(r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }

            while (check() && l <= r) {
                if( r - l - 1 < len) {
                    len = r - l - 1;
                    ansL = l;
                    ansR = r + 1;
                }
            
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l),  0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private boolean check() {
        for(Entry<Character, Integer> entry : ori.entrySet()) {
            if (cnt.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
