/*
 * @Author: Tungbo
 * @Date: 2024-03-13 21:50:06
 * @LastEditTime: 2024-03-13 21:50:11
 * @LastEditors: Tungbo
 * @Description: leecode: 2864. 最大二进制奇数
 */
package wyx.leetcode2024.wyx20240311;

public class Solution2864 {
    public String maximumOddBinaryNumber(String s) {
        int cnt1 = (int) s.chars().filter(c -> c == '1').count();
        return "1".repeat(cnt1 - 1) + "0".repeat(s.length() - cnt1) + "1";
    }
}
