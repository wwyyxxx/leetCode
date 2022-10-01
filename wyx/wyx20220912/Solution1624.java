/*
 * @Author: Tungbo
 * @Date: 2022-09-17 19:41:46
 * @LastEditTime: 2022-09-17 19:45:16
 * @LastEditors: Tungbo
 * @Description: leecode: 1624. 两个相同字符之间的最长子字符串
 * 
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1
 * 子字符串 是字符串中的一个连续字符序列
 * 
 */
package wyx.wyx20220912;

import java.util.HashMap;
import java.util.Map;

public class Solution1624 {

    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                ans = Math.max(ans, i - map.get(chars[i]) - 1);
            } else {
                map.put(chars[i], i);
            }
        }
        return ans;
    }

}
