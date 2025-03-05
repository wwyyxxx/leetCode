/*
 * @Author: Tungbo
 * @Date: 2025-03-05 21:53:45
 * @LastEditTime: 2025-03-05 21:53:50
 * @LastEditors: Tungbo
 * @Description: leecode: 1328. 破坏回文串
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250303;

public class Solution1328 {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        char[] ch = palindrome.toCharArray();
        for (int i = 0; i < ch.length / 2; i++) {
            if (ch[i] != 'a') {
                ch[i] = 'a';
                return new String(ch);
            }
        }
        ch[ch.length - 1] = 'b';
        return new String(ch);
    }
}
