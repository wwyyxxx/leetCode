/*
 * @Author: Tungbo
 * @Date: 2022-07-05 15:28:09
 * @LastEditTime: 2022-07-05 15:59:41
 * @LastEditors: Tungbo
 * @Description: leecode: 729. 我的日程安排表 I
 * 
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
 * 日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end
 * 
 */
package wyx.wyx20220704;

import java.util.ArrayList;
import java.util.List;

public class Solution729 {
    
    List<int[]> list;

    public Solution729() {
        list = new ArrayList<int[]>();
    }
    
    public boolean book(int start, int end) {
        for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            //满足 开始时间大于等于结束时间 || 结束时间小于等于开始时间
            //所以 开始时间小于结束时间 &&　结束时间大于开始时间
            if(start < temp[1] && end > temp[0]) return false;
        }
        list.add(new int[]{start,end});
        return true;
    }

}
