package practice.leetcode.src.wyx.leetcode2023.wyx20230828;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author: Tungbo
 * @Date: 2023-08-28 23:26:32
 * @LastEditTime: 2023-08-28 11:31:23
 * @LastEditors: Tungbo
 * @Description: leecode: 57. 插入区间
 */
public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int l = intervals.length;
        while(i < l && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }

        while(i < l && (intervals[i][1] <= newInterval[1] || intervals[i][0] <= newInterval[1])) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);
        while(i < l) {
            list.add(intervals[i++]);
        }
        return list.toArray(new int[0][]);
    }
}
