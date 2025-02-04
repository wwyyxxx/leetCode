/*
 * @Author: Tungbo
 * @Date: 2023-01-10 19:45:24
 * @LastEditTime: 2023-01-13 16:08:26
 * @LastEditors: Tungbo
 * @Description: leecode: 753. 破解保险箱
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230109;

import java.util.Arrays;

public class Solution753 {
    private String crackSafe(int n, int k) {
        int kn = (int)Math.pow(k, n), kn_1 = (int)Math.pow(k, n-1);
        int[] num = new int[kn_1];
        Arrays.fill(num, k-1);
        char[] c = new char[kn+n-1];
        Arrays.fill(c, '0');
        for (int i = n-1, node = 0; i < c.length; i++) {
            c[i] = (char)('0'+num[node]--);
            node = node * k- (c[i-(n-1)] - '0')* kn_1 + num[node] + 1;
        }
        return new String(c);
    }
}
