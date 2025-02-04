/*
 * @Author: Tungbo
 * @Date: 2023-02-19 21:38:29
 * @LastEditTime: 2023-02-19 21:38:33
 * @LastEditors: Tungbo
 * @Description: leecode: 1792. 最大平均通过率
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230213;

import java.util.PriorityQueue;

public class Solution1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> {
            double x = (a[0] + 1) / (a[1] + 1) - a[0]/a[1];
            double y = (b[0] + 1) / (b[1] + 1) - b[0]/b[1];
            return Double.compare(y, x);
        });
        for(int[] e : classes) {
            pq.offer(new double[]{e[0],e[1]});
        }
        while(extraStudents-- > 0) {
            double[] temp = pq.poll();
            double a = temp[0]+1, b = temp[1]+1;
            pq.offer(new double[]{a,b});
        }
        double ans = 0;
        while(!pq.isEmpty()){
            double[] temp = pq.poll();
            ans+=temp[0]/temp[1];
        }
        return ans/classes.length;
    }
}
