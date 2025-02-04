/*
 * @Author: Tungbo
 * @Date: 2022-08-14 16:27:09
 * @LastEditTime: 2022-08-14 16:50:40
 * @LastEditors: Tungbo
 * @Description: leecode: 1422. 分割字符串的最大得分
 * 
 * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220808;

public class Solution1422 {
    
    public int maxScore(String s) {
        int count1 = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '1') count1++;
        }
        int ans = count1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '1') count1--;
            else count1++;
            if(ans < count1) ans = count1;
        }
        if(s.charAt(0) == '0') ans++;
        return ans;
    }

}
