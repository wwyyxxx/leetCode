/*
 * @Author: Tungbo
 * @Date: 2023-04-30 10:52:16
 * @LastEditTime: 2023-04-26 10:53:22
 * @LastEditors: Tungbo
 * @Description: leecode: 1031. 两个非重叠子数组的最大和
 */
package wyx.wyx20230424;

import java.util.Arrays;

public class Solution1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] p = new int[]{a, b, c};
        Arrays.sort(p);
        a = p[0]; b = p[1]; c = p[2];
        return new int[]{c - a == 2 ? 0 :
                         b - a <= 2 || c - b <= 2 ? 1 : 2,
                         c - a - 2};
    }
}
