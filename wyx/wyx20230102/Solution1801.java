/*
 * @Author: Tungbo
 * @Date: 2023-01-02 18:41:28
 * @LastEditTime: 2023-01-02 19:08:41
 * @LastEditors: Tungbo
 * @Description: leecode: 1801. 积压订单中的订单总数
 */
package wyx.wyx20230102;

import java.util.PriorityQueue;

public class Solution1801 {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sell = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] order : orders) {
            int p = order[0], a = order[1], t = order[2];
            if (t == 0) {
                while (a > 0 && !sell.isEmpty() && sell.peek()[0] <= p) {
                    var q = sell.poll();
                    int x = q[0], y = q[1];
                    if (a >= y) {
                        a -= y;
                    } else {
                        sell.offer(new int[] {x, y - a});
                        a = 0;
                    }
                }
                if (a > 0) {
                    buy.offer(new int[] {p, a});
                }
            } else {
                while (a > 0 && !buy.isEmpty() && buy.peek()[0] >= p) {
                    var q = buy.poll();
                    int x = q[0], y = q[1];
                    if (a >= y) {
                        a -= y;
                    } else {
                        buy.offer(new int[] {x, y - a});
                        a = 0;
                    }
                }
                if (a > 0) {
                    sell.offer(new int[] {p, a});
                }
            }
        }
        long ans = 0;
        final int mod = (int) 1e9 + 7;
        while (!buy.isEmpty()) {
            ans += buy.poll()[1];
        }
        while (!sell.isEmpty()) {
            ans += sell.poll()[1];
        }
        return (int) (ans % mod);
    }
}
