/*
 * @Author: Tungbo
 * @Date: 2024-12-26 22:20:32
 * @LastEditTime: 2024-12-26 22:40:34
 * @LastEditors: Tungbo
 * @Description: leecode: 3083. 字符串及其反转中是否存在同一子字符串
 */
 package wyx.leetcode2024.wyx20241223;
 
 public class Solution3083 {
 
    public boolean isSubstringPresent(String s) {
        int n = s.length();
        if (n < 2) {
            return false;
        }

        for (int i = 1; i < n; i++) {
            String resveString = new StringBuilder(s.substring(i-1, i+1)).reverse().toString();
            if (s.indexOf(resveString) != -1) {
                return true;
            }
        }
        return false;
    }

 }