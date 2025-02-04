/*
 * @Author: Tungbo
 * @Date: 2023-01-01 18:27:42
 * @LastEditTime: 2023-01-01 18:32:56
 * @LastEditors: Tungbo
 * @Description: leecode: 2351. 第一个出现两次的字母
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221226;

import java.util.HashMap;
import java.util.Map;

public class Solution2351 {
    public char repeatedCharacter(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()) {
            if(map.containsKey(c)) return c;
            map.put(c,1);
        }
        return 'a';
    }
}
