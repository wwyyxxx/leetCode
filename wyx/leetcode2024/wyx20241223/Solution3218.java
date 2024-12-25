/*
 * @Author: Tungbo
 * @Date: 2024-12-25 22:38:20
 * @LastEditTime: 2024-12-25 23:24:48
 * @LastEditors: Tungbo
 * @Description: leecode: 3218. 切蛋糕的最小总开销 I
 */
package wyx.leetcode2024.wyx20241223;

import java.util.Arrays;

public class Solution3218 {

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int v = 1, h = 1;
        int ans = 0;
        int i = horizontalCut.length - 1;
        int j = verticalCut.length - 1;
        while (i >= 0 || j >= 0) {
            if (j < 0 || ( i>= 0 && horizontalCut[i] > verticalCut[j])) {
                ans += horizontalCut[i--] * v;
                h++;
            } else {
                ans += verticalCut[j--] * h;
                v++;
            }
        }
        return ans;
    }
}