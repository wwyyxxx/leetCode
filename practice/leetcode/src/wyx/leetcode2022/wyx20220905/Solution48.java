package practice.leetcode.src.wyx.leetcode2022.wyx20220905;

import java.util.HashMap;

/*
 * @Author: Tungbo
 * @Date: 2022-09-05 18:38:51
 * @LastEditTime: 2022-09-05 18:29:11
 * @LastEditors: Tungbo
 * @Description: leecode: 剑指 Offer 48. 最长不含重复字符的子字符串
 * 
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 
 */
public class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left = -1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)));
                
            }
            map.put(s.charAt(i), i);
            res = Math.max(res,i - left);
        }
        return res;
    }
}
