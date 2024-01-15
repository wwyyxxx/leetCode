/*
 * @Author: Tungbo
 * @Date: 2022-06-27 12:16:26
 * @LastEditTime: 2022-06-27 12:41:11
 * @LastEditors: Tungbo
 * @Description: leecode: 522. 最长特殊序列 II
 * 
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列
 * 
 */
package wyx.wyx20220627;

public class Solution522 {
    
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            boolean check = true;
            for (int j = 0; j < n; j++) {
                if(i != j && isSub(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    private boolean isSub(String s, String t) { //是否子串
        int ptS = 0, ptT = 0;
        while (ptS < s.length() && ptT < t.length()) {
            if (s.charAt(ptS) == t.charAt(ptT)) {
                ++ptS;
            }
            ++ptT;
        }
        return ptS == s.length();
    }

}
