package wyx.wyx20220530;

import java.util.*;

/*
 * @Author: Tungbo
 * @Date: 2022-06-01 15:12:17
 * @LastEditTime: 2022-06-02 16:29:29
 * @LastEditors: Tungbo
 * @Description: leecode: 438. 找到字符串中所有字母异位词
 * 
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length()) return res;
        int l = 0, r = 0;
        int[] ps = new int[26];
        int[] ss = new int[26];
        //存下对比字符串的值
        for(int i = 0; i <  p.length(); i++) {
            ps[p.charAt(i) - 'a']++;
            ss[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(ps,ss)) {
            res.add(0);
        }
        int len = s.length() - p.length();
        for(int i = 0; i < len; i++) {
            //i类比左边界 ，往右移动
            ss[s.charAt(i) - 'a']--;
            ss[s.charAt(i+p.length()) - 'a']++;
            if(Arrays.equals(ps,ss)) {
                res.add(i+1);
            }
        }
        return res;
    }
}