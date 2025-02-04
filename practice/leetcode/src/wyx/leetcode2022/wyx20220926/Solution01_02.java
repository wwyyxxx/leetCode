/*
 * @Author: Tungbo
 * @Date: 2022-09-27 14:54:59
 * @LastEditTime: 2022-09-27 14:59:21
 * @LastEditors: Tungbo
 * @Description: leecode: 面试题 01.02. 判定是否互为字符重排
 * 
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220926;

import java.util.Arrays;

public class Solution01_02 {

    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
    
}
