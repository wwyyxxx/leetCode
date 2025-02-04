/*
 * @Author: Tungbo
 * @Date: 2023-03-30 11:06:49
 * @LastEditTime: 2023-03-30 11:07:05
 * @LastEditors: Tungbo
 * @Description: leecode: 两点之间不包含任何点的最宽垂直区域
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230327;

import java.util.Arrays;

public class Solution1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a,b)-> a[0] - b[0]);
        int diff = 0;
        for(int i = 0; i < points.length - 1; i++) {
            diff = Math.max(diff,points[i+1][0] - points[i][0]);
        }
        return diff;
    }
}
