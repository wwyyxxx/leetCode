/*
 * @Author: Tungbo
 * @Date: 2025-02-20 21:24:09
 * @LastEditTime: 2025-02-20 21:37:13
 * @LastEditors: Tungbo
 * @Description: leecode: 2595. 奇偶位数
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250217;

public class Solution2595 {
    public int[] evenOddBit(int n) {
        String str = Integer.toBinaryString(n);
        int even = 0, odd = 0;
        for (int i = str.length() - 1, j = 0; i >= 0; i--, j++) {
            if (str.charAt(i) == '1') {
                if (j % 2 == 0)
                    even++;
                else
                    odd++;
            }
        }
        return new int[] {even, odd};
    }
}
