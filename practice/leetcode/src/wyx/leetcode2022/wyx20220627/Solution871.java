/*
 * @Author: Tungbo
 * @Date: 2022-07-02 22:09:16
 * @LastEditTime: 2022-07-02 22:26:23
 * @LastEditors: Tungbo
 * @Description: leecode: 871. 最低加油次数
 * 
 * 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
 * 沿途有加油站，每个 station[i] 代表一个加油站，它位于出发位置东面 station[i][0] 英里处，并且有 station[i][1] 升汽油。
 * 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。
 * 当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
 * 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
 * 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220627;

import java.util.PriorityQueue;

public class Solution871 {
    
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a,b) -> b -a);
        int ans = 0, pre = 0, fuel = startFuel;
        int n = stations.length;
        for (int i = 0; i <= n; i++) {
            int cur = i < n ? stations[i][0] : target;
            fuel = fuel - (cur - pre);
            while(fuel < 0 && !q.isEmpty()) {
                fuel += q.poll();
                ans++;
            }
            if(fuel < 0) return -1;
            if(i < n){
                q.offer(stations[i][1]);
                pre = cur;
            }
        }
        return ans;
    }

}
