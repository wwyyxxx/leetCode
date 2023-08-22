/*
 * @Author: Tungbo
 * @Date: 2023-08-22 14:48:18
 * @LastEditTime: 2023-08-22 15:03:34
 * @LastEditors: Tungbo
 * @Description: leecode: 849. 到最近的人的最大距离
 */
package wyx.wyx20230821;

import java.util.ArrayList;
import java.util.List;

public class Solution849 {
    public int maxDistToClosest(int[] seats) {
        int first = -1, last = -1;
        int d = 0, n = seats.length;
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
                if (last != -1) {
                    d = Math.max(d, i - last);
                }
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        return Math.max(d / 2, Math.max(first, n - last - 1));
    }
}
