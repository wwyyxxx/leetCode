/*
 * @Author: Tungbo
 * @Date: 2022-12-10 20:20:25
 * @LastEditTime: 2022-12-10 21:20:05
 * @LastEditors: Tungbo
 * @Description: leecode: 1691. 堆叠长方体的最大高度
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221205;

import java.util.Arrays;

public class Solution1691 {
    public int maxHeight(int[][] cuboids) {
        for (int i = 0; i < cuboids.length; i++) {
            Arrays.sort(cuboids[i]);
        }
        Arrays.sort(cuboids, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
        int ans = 0;
        int[] t = new int[cuboids.length];
        for (int i = 0; i < cuboids.length; i++) {
            for (int j = 0; j < i; j++) {
                if (cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    t[i] = Math.max(t[j], t[i]);
                }
            }
            t[i] += cuboids[i][2];
            ans = Math.max(ans, t[i]);
        }
        return ans;
    }
}
