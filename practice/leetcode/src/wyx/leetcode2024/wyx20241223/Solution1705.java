/*
 * @Author: Tungbo
 * @Date: 2024-12-24 20:27:39
 * @LastEditTime: 2024-12-24 20:31:52
 * @LastEditors: Tungbo
 * @Description: leecode: 1705. 吃苹果的最大数目
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20241223;

import java.util.PriorityQueue;

class Solution1705 {

    public int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < apples.length || !pq.isEmpty(); i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= i) {
                pq.poll();
            }

            if (i < apples.length && apples[i] > 0) {
                pq.offer(new int[]{days[i] + i, apples[i]});
            }

            if (!pq.isEmpty()) {
                if (--pq.peek()[1] == 0) {
                    pq.poll();
                }
                ans++;
            }
        }

        return ans;
    }

}