/*
 * @Author: Tungbo
 * @Date: 2023-09-12 16:53:40
 * @LastEditTime: 2023-09-12 17:01:08
 * @LastEditors: Tungbo
 * @Description: leecode: 630. 课程表 III
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230911;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution630 {
    public int scheduleCourse(int[][] courses) {
        int curDay = 0;
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
        for(int[] temp : courses) {
            int d = temp[0], l = temp[1];
            curDay += d;
            q.add(d);
            if(curDay > l) curDay -= q.poll();
        }
        return q.size();
    }
}
