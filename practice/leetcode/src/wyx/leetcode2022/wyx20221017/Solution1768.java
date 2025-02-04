/*
 * @Author: Tungbo
 * @Date: 2022-10-23 18:37:39
 * @LastEditTime: 2022-10-23 18:45:40
 * @LastEditors: Tungbo
 * @Description: leecode: 1768. 交替合并字符串
 * 
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。
 * 如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * 返回 合并后的字符串 。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221017;

public class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int i1 = 0, i2 = 0;
        StringBuilder sb = new StringBuilder();
        while(i1 < l1 && i2 < l2) {
            sb.append(word1.charAt(i1++));
            sb.append(word1.charAt(i2++));
        }
        if(i1 != l1 || i2 != l2) {
            sb.append(
                i1!=l1?word1.substring(i1, l1):word2.substring(i2, l2)
            );
        }
        return sb.toString();
    }
}
