/*
 * @Author: Tungbo
 * @Date: 2023-02-21 16:45:07
 * @LastEditTime: 2023-02-21 16:45:10
 * @LastEditors: Tungbo
 * @Description: leecode: 763. 划分字母区间
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230220;

import java.util.ArrayList;
import java.util.List;

public class Solution763 {
    public List<Integer> partitionLabels(String s) {
        int[] dic = new int[26];
        char[] cs = s.toCharArray();
        for(char c: cs) {
            dic[c - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        int[] temp = new int[26];
        int cur = 0;
        for(int i = 0; i < cs.length; i++) {
            temp[cs[i]-'a'] = --dic[cs[i]-'a'];
            boolean flag = true;
            for(int t: temp) {
                if(t>0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                ans.add(i+1 - cur);
                cur = i+1;
            }
        }
        return ans;
    }
}
