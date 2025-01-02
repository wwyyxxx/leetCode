/*
 * @Author: Tungbo
 * @Date: 2022-06-06 16:14:49
 * @LastEditTime: 2022-06-06 16:20:00
 * @LastEditors: Tungbo
 * @Description: leecode: 732. 我的日程安排表 III
 * 
 * 当 k 个日程安排有一些时间上的交叉时（例如 k 个日程安排都在同一时间内），就会产生 k 次预订。
 * 给你一些日程安排 [start, end) ，请你在每个日程安排添加后，返回一个整数 k ，表示所有先前日程安排会产生的最大 k 次预订。
 * 实现一个 MyCalendarThree 类来存放你的日程安排，你可以一直添加新的日程安排。
 *      MyCalendarThree() 初始化对象。
 *      int book(int start, int end) 返回一个整数 k ，表示日历中存在的 k 次预订的最大值。
 * 
 */
package wyx.leetcode2022.wyx20220606;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarThree {
    
    //排序树，会自动排序
    TreeMap<Integer, Integer> tree;
    int ans = 0;
    
    public MyCalendarThree() {
        tree = new TreeMap<Integer, Integer>();
    }
    
    public int book(int start, int end) {
        tree.put(start, tree.getOrDefault(start,0) + 1);
        tree.put(end, tree.getOrDefault(end,0) - 1);
        int bookmax = 0;
        for(Map.Entry<Integer, Integer> entry : tree.entrySet()) {
            int temp = entry.getValue();
            bookmax += temp;
            ans = Math.max(bookmax,ans);
        }
        return ans;
    }

}
