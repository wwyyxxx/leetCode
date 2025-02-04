
package practice.leetcode.src.wyx.leetcode2025.wyx20250203;

/*
 * @Author: Tungbo
 * @Date: 2025-01-27 00:06:50
 * @LastEditTime: 2025-02-03 10:34:11
 * @LastEditors: Tungbo
 * @Description: leecode: 680. 验证回文串 II
 */
public class Solution680 {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
