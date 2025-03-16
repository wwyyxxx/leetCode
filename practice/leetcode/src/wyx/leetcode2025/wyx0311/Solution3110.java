/*
 * @Author: Tungbo
 * @Date: 2025-03-16 21:10:15
 * @LastEditTime: 2025-03-16 21:17:54
 * @LastEditors: Tungbo
 * @Description: leecode: 3110. 字符串的分数
 */
package practice.leetcode.src.wyx.leetcode2025.wyx0311;

public class Solution3110 {
    public int scoreOfString(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() -1; i++) {
            sum += Math.abs(s.charAt(i) - s.charAt(i+ 1));
        }
        return sum;
    }
}
