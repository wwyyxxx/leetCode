/*
 * @Author: Tungbo
 * @Date: 2024-03-07 13:44:11
 * @LastEditTime: 2024-03-07 14:05:28
 * @LastEditors: Tungbo
 * @Description: leecode: 2575. 找出字符串的可整除数组
 */
package wyx.leetcode2024.wyx20240304;

public class Solution2575 {
    public int[] divisibilityArray(String word, int m) {
        char[] ch = word.toCharArray();
        int n = ch.length;
        long div = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            div = div * 10 + (ch[i] - '0') % m;
            res[i] = div == 0 ? 1 : 0;  
        }
        return res;
    }
}
