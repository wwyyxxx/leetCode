package practice.leetcode.src.wyx.leetcode2023.wyx20230313;

/*
 * @Author: Tungbo
 * @Date: 2023-03-18 12:00:11
 * @LastEditTime: 2023-03-18 12:03:09
 * @LastEditors: Tungbo
 * @Description: leecode: 1616. 分割两个字符串得到回文串
 */
public class Solution1616 {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a,b) || check(b, a);
    }

    private boolean check(String a, String b) {
        int i = 0, j = a.length() - 1;
        while(i < j && a.charAt(i) == b.charAt(j)) {
            i++;
            j--;
        }
        return isPalindrome(a,i,j) || isPalindrome(b,i,j);
    }

    private boolean isPalindrome(String s, int start,int end) {
        while(start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start >= end;
    }
}
