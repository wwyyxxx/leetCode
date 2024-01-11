/*
 * @Author: Tungbo
 * @Date: 2024-01-11 18:02:51
 * @LastEditTime: 2024-01-11 18:51:02
 * @LastEditors: Tungbo
 * @Description: leecode: 2645. 构造有效字符串的最少插入数
 */
package wyx.wyx20240109;

public class Solution2645 {
    public int addMinimum(String word) {
        char[] s = word.toCharArray();
        int t = 1;
        for (int i = 1; i<s.length; i++) {
            if (s[i-1] >= s[i]) {
                t++;
            }
        }
        return t * 3 - s.length;
    }
}
