/*
 * @Author: Tungbo
 * @Date: 2022-09-11 15:17:39
 * @LastEditTime: 2022-09-11 15:18:42
 * @LastEditors: Tungbo
 * @Description: leecode: 857. 雇佣 K 名工人的最低成本
 * 
 * 有 n 名工人。 给定两个数组 quality 和 wage ，其中，quality[i] 表示第 i 名工人的工作质量，其最低期望工资为 wage[i] 
 * 现在我们想雇佣 k 名工人组成一个工资组。在雇佣 一组 k 名工人时，我们必须按照下述规则向他们支付工资
 *  1.对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资
 *  2.工资组中的每名工人至少应当得到他们的最低期望工资
 * 给定整数 k ，返回 组成满足上述条件的付费群体所需的最小金额 。在实际答案的 10-5 以内的答案将被接受
 * 
 */
package wyx.wyx20220829;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution875 {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length, sumQ = 0;
        var id = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(id, (i, j) -> wage[i] * quality[j] - wage[j] * quality[i]); // 按照 r 值排序
        var pq = new PriorityQueue<Integer>((a, b) -> b - a); // 最大堆
        for (var i = 0; i < k; ++i) {
            pq.offer(quality[id[i]]);
            sumQ += quality[id[i]];
        }
        var ans = sumQ * ((double) wage[id[k - 1]] / quality[id[k - 1]]); // 选 r 值最小的 k 名工人组成当前的最优解
        for (var i = k; i < n; ++i) {
            var q = quality[id[i]];
            if (q < pq.peek()) { // sumQ 可以变小，从而可能得到更优的答案
                sumQ -= pq.poll() - q;
                pq.offer(q);
                ans = Math.min(ans, sumQ * ((double) wage[id[i]] / q));
            }
        }
        return ans;
    }
}
