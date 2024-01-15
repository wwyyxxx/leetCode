/*
 * @Author: Tungbo
 * @Date: 2024-01-12 10:48:15
 * @LastEditTime: 2024-01-15 15:09:18
 * @LastEditors: Tungbo
 * @Description: leecode: 2085. 统计出现过一次的公共字符串
 */
package wyx.leetcode2024.wyx20240109;

import java.util.HashMap;
import java.util.Map;

public class Solution2085 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(String s : words1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for(String s : words2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for(String key : map1.keySet()) {
            if (map1.get(key) ==1 && map2.getOrDefault(key,0) == 1) {
                res++;
            }
        }
        return res;
    }
}
