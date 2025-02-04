/*
 * @Author: Tungbo
 * @Date: 2025-01-11 12:10:05
 * @LastEditTime: 2025-01-11 13:27:47
 * @LastEditors: Tungbo
 * @Description: leecode: 3270. 求出数字答案
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20250106;

public class Solution3270 {
    public int generateKey(int num1, int num2, int num3) {
        String num1Str = generateString(num1);
        String num2Str = generateString(num2);
        String num3Str = generateString(num3);
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            ans += Math.pow(10, 3-i) * Math.min(num1Str.charAt(i) - '0', Math.min(num2Str.charAt(i) - '0', num3Str.charAt(i) - '0'));
        }
        return ans;
    }

    private String generateString(int num1) {
        String temp = String.valueOf(num1);
        String perx = "";
        for (int i = 0; i < 4 - temp.length(); i++) {
            perx +="0";
        }
        return perx + temp;
    }
}
