/*
 * @Author: Tungbo
 * @Date: 2022-10-14 15:19:52
 * @LastEditTime: 2022-10-14 15:50:01
 * @LastEditors: Tungbo
 * @Description: leecode: 940. 不同的子序列 II
 * 
 * 给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余
 * 字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串
 *  例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是
 * 
 */
package wyx.wyx20221010;

public class Solution940 {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        int n = s.length();
        int[] preCount = new int[26];
        int ans = 1;
        char[] ch = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int newCount = ans;
            ans = ((ans + newCount) % mod - preCount[ch[i] - 'a'] % mod + mod) % mod;
            preCount[ch[i] - 'a'] = newCount;
        }
        return ans - 1;
    }
}
