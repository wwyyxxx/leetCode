/*
 * @Author: Tungbo
 * @Date: 2024-04-17 11:31:05
 * @LastEditTime: 2024-04-17 11:31:07
 * @LastEditors: Tungbo
 * @Description: leecode: 928. 尽量减少恶意软件的传播 II
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240415;

public class Solution928 {
    private int nodeId, size;

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] isInitial = new boolean[n];
        int mn = Integer.MAX_VALUE;
        for (int x : initial) {
            isInitial[x] = true;
            mn = Math.min(mn, x);
        }

        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] || isInitial[i]) {
                continue;
            }
            nodeId = -1;
            size = 0;
            dfs(i, graph, vis, isInitial);
            if (nodeId >= 0) { // 只找到一个在 initial 中的节点
                // 删除节点 nodeId 可以让 size 个点不被感染
                cnt[nodeId] += size;
            }
        }

        int maxCnt = 0;
        int minNodeId = -1;
        for (int i = 0; i < n; i++) {
            if (cnt[i] > 0 && (cnt[i] > maxCnt || cnt[i] == maxCnt && i < minNodeId)) {
                maxCnt = cnt[i];
                minNodeId = i;
            }
        }
        return minNodeId < 0 ? mn : minNodeId;
    }

    private void dfs(int x, int[][] graph, boolean[] vis, boolean[] isInitial) {
        vis[x] = true;
        size++;
        for (int y = 0; y < graph.length; y++) {
            if (graph[x][y] == 0) {
                continue;
            }
            if (isInitial[y]) {
                // 按照 924 题的状态机更新 nodeId
                // 注意避免重复统计，例如上图中的 0 有两条不同路径可以遇到 1
                if (nodeId != -2 && nodeId != y) {
                    nodeId = nodeId == -1 ? y : -2;
                }
            } else if (!vis[y]) {
                dfs(y, graph, vis, isInitial);
            }
        }
    }
}
