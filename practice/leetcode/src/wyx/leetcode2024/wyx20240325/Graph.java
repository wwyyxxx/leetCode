/*
 * @Author: Tungbo
 * @Date: 2024-03-26 10:05:14
 * @LastEditTime: 2024-03-26 10:53:23
 * @LastEditors: Tungbo
 * @Description: leecode: 2642. 设计可以求最短路径的图类
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240325;

import java.util.Arrays;

public class Graph {

    private static final int INF = Integer.MAX_VALUE / 2; // 防止更新最短路时加法溢出
    private final int[][] g;
    
    public Graph(int n, int[][] edges) {
        g = new int[n][n];
        for(int[] row : g) {
            Arrays.fill(row, INF);
        }
        for (int[] e : edges) {
            addEdge(e);
        }
    }
    
    public void addEdge(int[] edge) {
        g[edge[0]][edge[1]] = edge[2];
    }
    
    public int shortestPath(int start, int end) {
        int n = g.length;
        int[] dis = new int[n];
        Arrays.fill(dis, INF);
        boolean[] vis = new boolean[n];
        while (true) {
            int x = -1;
            for (int i = 0; i < n; i++) {
                if(!vis[i] && (x < 0 || dis[i] < dis[x])) {
                    x = i;
                }
            }
            if (x < 0 || dis[x] == INF) {
                return -1;
            }
            if (x == end) {
                return dis[x];
            }

            vis[x] = true;
            for(int y = 0; y < n; y++) {
                dis[y] = Math.min(dis[y], dis[x] + g[x][y]); // 更新最短路长度
            }
        }
    }

}
