/*
 * @Author: Tungbo
 * @Date: 2025-01-04 20:13:52
 * @LastEditTime: 2025-01-04 20:16:29
 * @LastEditors: Tungbo
 * @Description: leecode: 732. 我的日程安排表 III
 */
package wyx.leetcode2024.wyx20241230;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarThree {
    private TreeMap<Integer, Integer> cnt;

    public MyCalendarThree() {
        cnt = new TreeMap<Integer, Integer>();
    }

    
    public int book(int startTime, int endTime) {
        int ans = 0;
        int maxBook = 0;
        cnt.put(startTime, cnt.getOrDefault(startTime, 0)+1);
        cnt.put(endTime, cnt.getOrDefault(endTime, 0)-1);
        for(Map.Entry<Integer,Integer> entry : cnt.entrySet()) {
            int freq = entry.getValue();
            maxBook += freq;
            ans = Math.max(ans, maxBook);
        }
        return ans;
    }
}
