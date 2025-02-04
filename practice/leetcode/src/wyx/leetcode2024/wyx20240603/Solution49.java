package practice.leetcode.src.wyx.leetcode2024.wyx20240603;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: Tungbo
 * @Date: 2024-06-05 21:59:19
 * @LastEditTime: 2024-06-05 20:39:00
 * @LastEditors: Tungbo
 * @Description: leecode: 49. 字母异位词分组
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> dic = new HashMap<>();
        for(String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            dic.computeIfAbsent(new String(chs), k -> new ArrayList<>()).add(str);
            
        }
        return new ArrayList<>(dic.values());
    }
}
