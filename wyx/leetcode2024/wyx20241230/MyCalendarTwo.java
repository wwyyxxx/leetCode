package wyx.leetcode2024.wyx20241230;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author: Tungbo
 * @Date: 2025-01-02 22:54:19
 * @LastEditTime: 2025-01-03 21:53:32
 * @LastEditors: Tungbo
 * @Description: leecode: 729. 我的日程安排表 II
 */
public class MyCalendarTwo {

    List<int[]> booked;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        booked = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for(int[] overlap : overlaps) {
            int l = overlap[0], r = overlap[1];
            if (l < endTime && r > startTime) {
                return false;
            }
        }
        for(int[] book : booked) {
            int l = book[0], r = book[1];
            if (l < endTime && r > startTime) {
                overlaps.add(new int[]{Math.max(startTime, l), Math.min(endTime, r)});
            }
        }
        booked.add(new int[]{startTime, endTime});
        return true;
    }
}
