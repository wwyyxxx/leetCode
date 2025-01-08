/*
 * @Author: Tungbo
 * @Date: 2025-01-08 11:47:38
 * @LastEditTime: 2025-01-08 14:07:39
 * @LastEditors: Tungbo
 * @Description: leecode: 2264. 字符串中最大的 3 位相同数字
 */
package wyx.leetcode2024.wyx20250106;

public class Solution2264 {

    public String largestGoodInteger(String num) {
        char temp = 0;
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1)
                    && num.charAt(i) == num.charAt(i + 2)
                    && temp < num.charAt(i)) {
                temp = num.charAt(i);
            }
        }
        return temp > 0 ? String.valueOf(temp) + String.valueOf(temp) + String.valueOf(temp) : "";
    }

}
