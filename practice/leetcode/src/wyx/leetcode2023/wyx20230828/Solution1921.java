/*
 * @Author: Tungbo
 * @Date: 2023-09-03 22:26:29
 * @LastEditTime: 2023-09-03 22:30:12
 * @LastEditors: Tungbo
 * @Description: leecode: 1921. 消灭怪物的最大数量
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230828;

import java.util.Arrays;

public class Solution1921 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arrivalTimes = new int[n];
        for (int i = 0; i < n; i++) {
            arrivalTimes[i] = (dist[i] - 1) / speed[i] + 1;
        }
        Arrays.sort(arrivalTimes);
        for (int i = 0; i < n; i++) {
            if (arrivalTimes[i] <= i) {
                return i;
            }
        }
        return n;
    }
}
