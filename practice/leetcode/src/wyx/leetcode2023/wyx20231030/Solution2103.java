/*
 * @Author: Tungbo
 * @Date: 2023-11-02 19:38:50
 * @LastEditTime: 2023-11-02 19:38:53
 * @LastEditors: Tungbo
 * @Description: leecode: 2103. 环和杆
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20231030;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution2103 {
    public int countPoints(String rings) {
        int res = 0;
        Map<Character, HashSet<Character>> map = new HashMap<>();
        char[] ch = rings.toCharArray();
        for(int i = 1; i < ch.length; i+=2) {
            HashSet<Character> set = map.getOrDefault(ch[i], new HashSet<Character>());
            set.add(ch[i-1]);
            map.put(ch[i], set);
        }
        for(HashSet<Character> s : map.values()) {
            if(s.size() >=3)res++;
        }
        return res;
    }
}
