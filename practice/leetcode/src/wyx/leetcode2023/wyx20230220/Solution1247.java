/*
 * @Author: Tungbo
 * @Date: 2023-02-22 15:01:52
 * @LastEditTime: 2023-02-25 18:34:32
 * @LastEditors: Tungbo
 * @Description: leecode: 1247. 交换字符使得字符串相同
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230220;

public class Solution1247 {
    public int minimumSwap(String s1, String s2) {
        int[] cnt = new int[2];
        for (int i = 0, n = s1.length(); i < n; ++i)
            if (s1.charAt(i) != s2.charAt(i))
                ++cnt[s1.charAt(i) % 2]; // x 和 y ASCII 值的二进制最低位不同
        int d = cnt[0] + cnt[1];
        return d % 2 != 0 ? -1 : d / 2 + cnt[0] % 2;
    }
}
