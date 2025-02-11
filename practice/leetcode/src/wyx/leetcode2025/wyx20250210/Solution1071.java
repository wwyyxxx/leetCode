/*
 * @Author: Tungbo
 * @Date: 2025-02-11 10:18:12
 * @LastEditTime: 2025-02-11 10:27:55
 * @LastEditors: Tungbo
 * @Description: leecode: 1071. 字符串的最大公因子
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250210;

public class Solution1071 {
    public String gcdOfStrings(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        String t1 = str1 + str2;
        String t2 = str2 + str1;
        if (!t1.equals(t2)) {
            return "";
        }
        int index = gcb(m, n);
        return str2.substring(0, index);
    }

    private int gcb(int m, int n) {
        if (n == 0) {
            return m;
        }
        return gcb(n, m % n);
    }
}
