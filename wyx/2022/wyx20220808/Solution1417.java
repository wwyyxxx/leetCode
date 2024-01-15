/*
 * @Author: Tungbo
 * @Date: 2022-08-11 15:05:12
 * @LastEditTime: 2022-08-11 15:32:31
 * @LastEditors: Tungbo
 * @Description: leecode: 1417. 重新格式化字符串
 * 
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 
 * 
 */
package wyx.wyx20220808;


public class Solution1417 {
    
    public String reformat(String s) {
        StringBuilder a = new StringBuilder(), b = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c>='a') a.append(c);
            else b.append(c);
        }
        int n = a.length(), m =b.length(), totlen = s.length();
        if(Math.abs(n-m) > 1) return "";
        StringBuilder sb = new StringBuilder();
        while(sb.length() != totlen) {
            if(n>m) sb.append(a.charAt(--n));
            else if(n<m) sb.append(b.charAt(--m));
            else {
                if(sb.length() !=0 && sb.charAt(sb.length() - 1) >= 'a') sb.append(b.charAt(--m));
                else sb.append(a.charAt(--n));
            }
        }
        return sb.toString();
    }

}
