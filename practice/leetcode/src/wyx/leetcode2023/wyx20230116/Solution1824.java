/*
 * @Author: Tungbo
 * @Date: 2023-01-21 19:03:28
 * @LastEditTime: 2023-01-21 19:34:03
 * @LastEditors: Tungbo
 * @Description: leecode: 1824. 最少侧跳次数
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230116;

public class Solution1824 {
    public int minSideJumps(int[] obstacles) {
        int[] f = new int[]{1, 0, 1};
        for (int i = 1; i < obstacles.length; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (obstacles[i] == j + 1) {
                    f[j] = Integer.MAX_VALUE;
                    break;
                }
            }
            int x = Math.min(f[0], Math.min(f[1], f[2])) + 1;
            for (int j = 0; j < 3; ++j) {
                if (obstacles[i] != j + 1) {
                    f[j] = Math.min(f[j], x);
                }
            }
        }
        return Math.min(f[0], Math.min(f[1], f[2]));
    }
}
