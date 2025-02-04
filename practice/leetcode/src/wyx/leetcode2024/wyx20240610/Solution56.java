/*
 * @Author: Tungbo
 * @Date: 2024-06-16 17:52:56
 * @LastEditTime: 2024-06-16 18:10:42
 * @LastEditors: Tungbo
 * @Description: leecode: 56. 合并区间
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240610;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] arg0, int[] arg1) {
                return arg0[0] - arg1[0];
            }
            
        });

        List<int[]> res = new ArrayList<int[]>();
        for (int i = 0; i < n; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            if(res.size() == 0 || res.get(res.size() - 1)[1] < l) {
                res.add(intervals[i]);
            } else {
                res.get(res.size() -1)[1] = Math.max(res.get(res.size() -1)[1], r);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
