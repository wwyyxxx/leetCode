/*
 * @Author: Tungbo
 * @Date: 2024-03-27 11:27:28
 * @LastEditTime: 2024-03-27 11:40:29
 * @LastEditors: Tungbo
 * @Description: leecode: 2580. 统计将重叠区间合并成组的方案数
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240325;

import java.util.Arrays;

public class Solution2580 {

    public int countWays(int[][] ranges) {
        Arrays.sort(ranges,(a,b) -> a[0] - b[0]);
        int res = 1, maxR = -1;
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i][0] > maxR) {
                res = res * 2 % 1_000_000_007;
            }
            maxR = Math.max(maxR, ranges[i][1]);
        }
        return res;
    }

}
