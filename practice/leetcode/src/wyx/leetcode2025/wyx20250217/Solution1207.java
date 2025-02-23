/*
 * @Author: Tungbo
 * @Date: 2025-02-23 15:26:12
 * @LastEditTime: 2025-02-23 15:32:34
 * @LastEditors: Tungbo
 * @Description: leecode: 1207. 独一无二的出现次数
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250217;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> dic = new HashMap<Integer, Integer>();
        for(int num: arr) {
            dic.put(num, dic.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int cnt:dic.values()) {
            if (set.contains(cnt)) {
                return false;
            }
            set.add(cnt);
        }
        return true;
    }
}
