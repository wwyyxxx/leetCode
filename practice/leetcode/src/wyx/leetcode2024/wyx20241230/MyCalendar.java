/*
 * @Author: Tungbo
 * @Date: 2025-01-02 22:54:19
 * @LastEditTime: 2025-01-02 23:11:14
 * @LastEditors: Tungbo
 * @Description: leecode: 729. 我的日程安排表 I
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20241230;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MyCalendar {

    List<int[]> list;

    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            if (startTime < temp[1] && endTime > temp[0] ) {
                return false;
            }
        }
        list.add(new int[]{startTime, endTime});
        return true;
    }
}