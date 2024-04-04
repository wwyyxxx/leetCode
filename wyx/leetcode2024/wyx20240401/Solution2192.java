package wyx.leetcode2024.wyx20240401;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: Tungbo
 * @Date: 2024-04-04 17:21:36
 * @LastEditTime: 2024-04-04 17:32:03
 * @LastEditors: Tungbo
 * @Description: leecode: 2192. 有向无环图中一个节点的所有祖先
 */
public class Solution2192 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[1]].add(e[0]); // 反向建图
        }

        List<Integer>[] ans = new ArrayList[n];
        Arrays.setAll(ans, i -> new ArrayList<>());
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis, false);
            dfs(i, g, vis); // 从 i 开始 DFS
            vis[i] = false; // ans[i] 不含 i
            for (int j = 0; j < n; j++) {
                if (vis[j]) {
                    ans[i].add(j);
                }
            }
        }
        return Arrays.asList(ans);
    }

    private void dfs(int x, List<Integer>[] g, boolean[] vis) {
        vis[x] = true;
        for (int y : g[x]) {
            if (!vis[y]) {
                dfs(y, g, vis);
            }
        }
    }
}
