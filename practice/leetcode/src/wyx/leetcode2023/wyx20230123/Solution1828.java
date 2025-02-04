/*
 * @Author: Tungbo
 * @Date: 2023-01-24 15:06:53
 * @LastEditTime: 2023-01-24 15:10:05
 * @LastEditors: Tungbo
 * @Description: leecode: 1828. 统计一个圆中点的数目
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230123;

public class Solution1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1], r = queries[i][2];
            for (int[] p : points) {
                int dx = p[0] - x, dy = p[1] - y;
                if(dx*dx + dy*dy <= r*r) ans[i]++;
            }
        }
        return ans;
    }
}

