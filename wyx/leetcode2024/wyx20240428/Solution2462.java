/*
 * @Author: Tungbo
 * @Date: 2024-05-01 13:34:07
 * @LastEditTime: 2024-05-01 13:47:29
 * @LastEditors: Tungbo
 * @Description: leecode: 2462. 雇佣 K 位工人的总代价
 */
package wyx.leetcode2024.wyx20240428;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long ans = 0;
        if (candidates * 2 + k > n) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                ans += costs[i];
            }
            return ans;
        }

        PriorityQueue<Integer> pre = new PriorityQueue<>();
        PriorityQueue<Integer> suf = new PriorityQueue<>();
        for (int i = 0; i < candidates; i++) {
            pre.offer(costs[i]);
            suf.offer(costs[n - 1 - i]);
        }

        int i = candidates;
        int j = n - 1 - candidates;
        while (k-- > 0) {
            if (pre.peek() <= suf.peek()) {
                ans += pre.poll();
                pre.offer(costs[i++]);
            } else {
                ans += suf.poll();
                suf.offer(costs[j--]);
            }
        }
        return ans;
    }
}
