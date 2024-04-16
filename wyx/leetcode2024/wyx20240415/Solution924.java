/*
 * @Author: Tungbo
 * @Date: 2024-04-16 15:03:07
 * @LastEditTime: 2024-04-16 15:06:22
 * @LastEditors: Tungbo
 * @Description: leecode: 924. 尽量减少恶意软件的传播
 */
package wyx.leetcode2024.wyx20240415;

public class Solution924 {
    private int nodeId, size;

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] isInitial = new boolean[n];
        int mn = Integer.MAX_VALUE;
        for (int x : initial) {
            isInitial[x] = true;
            mn = Math.min(x, mn);
        }

        int ans = -1;
        int maxSize = 0;
        for (int x : initial) {
            if (vis[x])
                continue;
            size = 0;
            dfs(x, graph, vis, isInitial);
            if (nodeId >= 0 && (size > maxSize || size == maxSize && nodeId < ans)) {
                ans = nodeId;
                maxSize = size;
            }
        }
        return ans < 0 ? mn : ans;
    }

    private void dfs(int x, int[][] graph, boolean[] vis, boolean[] isInitial) {
        vis[x] = true;
        size++;
        // 按照状态机更新 nodeId
        if (nodeId != -2 && isInitial[x]) {
            nodeId = nodeId == -1 ? x : -2;
        }
        for (int y = 0; y < graph[x].length; y++) {
            if (graph[x][y] == 1 && !vis[y]) {
                dfs(y, graph, vis, isInitial);
            }
        }
    }
}
