/*
 * @Author: Tungbo
 * @Date: 2023-01-26 19:40:56
 * @LastEditTime: 2023-01-26 20:10:20
 * @LastEditors: Tungbo
 * @Description: leecode: 1663. 具有给定数值的最小字符串
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230123;

import java.util.Arrays;

public class Solution1663 {
    public String getSmallestString(int n, int k) {
        char[] ans = new char[n];
        Arrays.fill(ans, 'a');
        int i = n -1, d = k -n;
        for (; d>25; d-=25) {
            ans[i--] = 'z';
        }
        ans[i] = (char)('a' + d);
        return String.valueOf(ans);
    }
}
