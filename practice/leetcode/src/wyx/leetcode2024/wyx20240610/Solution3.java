/*
 * @Author: Tungbo
 * @Date: 2024-06-11 22:14:13
 * @LastEditTime: 2024-06-11 22:33:10
 * @LastEditors: Tungbo
 * @Description: leecode: 3. 无重复字符的最长子串
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240610;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        char[] chs = s.toCharArray();
        int res = 0;
        int i = -1, n = chs.length;
        for (int j = 0; j < n; j++) {
            if (dic.containsKey(chs[j])) {
                i = dic.get(chs[j]);
            }
            dic.put(chs[j], j - i);
            res = Math.max(res, j - i);
        }
        return res;
    }
}
