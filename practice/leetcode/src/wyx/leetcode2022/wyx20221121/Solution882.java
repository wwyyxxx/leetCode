/*
 * @Author: Tungbo
 * @Date: 2022-11-26 18:03:53
 * @LastEditTime: 2022-11-26 20:45:02
 * @LastEditors: Tungbo
 * @Description: leecode: 882. 细分图中的可到达节点
 * 
 * 给你一个无向图（原始图），图中有 n 个节点，编号从 0 到 n - 1 。
 * 你决定将图中的每条边 细分 为一条节点链，每条边之间的新节点数各不相同。
 * 
 * 现在得到一个 新的细分图 ，请你计算从节点 0 出发，可以到达多少个节点？如果节点间距离是 maxMoves 或更少，则视为 可以到达 。
 * 给你原始图和 maxMoves ，返回 新的细分图中从节点 0 出发 可到达的节点数 。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221121;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution882 {

    // edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], maxMoves = 10, n = 4
    // edges = [[0,1,10],[0,2,1],[1,2,2]], maxMoves = 6, n = 3
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<int[]>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], cnt = e[2];
            g[u].add(new int[]{v, cnt + 1});
            g[v].add(new int[]{u, cnt + 1}); // 建图 
        }
        int[] dist = dijkstra(g, 0); // 从 0 出发的最短路

        int ans = 0;
        for (int d : dist)
            if (d <= maxMoves) // 这个点可以在 maxMoves 步内到达
                ++ans;
        for (var e : edges) {
            int u = e[0], v = e[1], cnt = e[2];
            int a = Math.max(maxMoves - dist[u], 0);
            int b = Math.max(maxMoves - dist[v], 0);
            ans += Math.min(a + b, cnt); // 这条边上可以到达的节点数
        }
        return ans;
    }

    // Dijkstra 算法模板
    // 返回从 start 到每个点的最短路
    private int[] dijkstra(List<int[]>[] g, int start) {
        var dist = new int[g.length]; //start到每个点的最短路
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)-> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        while (!pq.isEmpty()) {
            var p = pq.poll();
            int x = p[0], d = p[1];
            // if (d > dist[x]) continue;
            for (var e : g[x]) {
                int y = e[0];
                int newDist = d + e[1];
                if (newDist < dist[y]) {
                    dist[y] = newDist;
                    pq.offer(new int[]{y, newDist});
                }
            }
        }
        return dist;
    }

}
