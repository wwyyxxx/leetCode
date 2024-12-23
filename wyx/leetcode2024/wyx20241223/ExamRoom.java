/*
 * @Author: Tungbo
 * @Date: 2024-12-23 20:14:10
 * @LastEditTime: 2024-12-23 20:37:49
 * @LastEditors: Tungbo
 * @Description: leecode: 855. 考场就座
 */
package wyx.leetcode2024.wyx20241223;

import java.util.TreeSet;

public class ExamRoom {

    // 用于存储已被占用的座位
    private TreeSet<Integer> treeSet;

    // 座位的最大编号
    int LEN;

    public ExamRoom(int n) {
        treeSet = new TreeSet<>();
        LEN = n - 1;
    }
    
    public int seat() {
        // q 表示上一个已占用的座位编号，s 表示当前选择的座位编号
        int prevSeat = 0, s = 0;
        // 如果没有学生入座，则选择 0 号座位，否则选择第一个已占用座位的编号
        int max = treeSet.isEmpty() ? LEN : treeSet.first();
        for (int seat : treeSet) {
            // 计算当前座位与上一个座位之间的中点
            int avg = (seat - prevSeat) / 2;
            // 如果当前中点距离大于最大距离，则更新选择的座位编号
            if (max < avg) {
                s = prevSeat + avg;
                max = avg;
            }
            // 更新上一个已占用的座位编号
            prevSeat = seat;
        }
        // 检查最后一个座位到考场末尾的距离
        if (max < LEN - prevSeat) {
            s = LEN;
        }
        treeSet.add(s);
        return s;
    }
    
    public void leave(int p) {
        treeSet.remove(p);
    }
}
