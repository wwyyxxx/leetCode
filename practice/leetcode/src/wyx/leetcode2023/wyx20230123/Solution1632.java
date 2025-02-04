/*
 * @Author: Tungbo
 * @Date: 2023-01-25 13:29:09
 * @LastEditTime: 2023-01-25 13:38:23
 * @LastEditors: Tungbo
 * @Description: leecode: 1632. 矩阵转换后的秩
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution1632 {
    public int[][] matrixRankTransform(int[][] mat) {
        // 并查集处理相同的值
        int m = mat.length, n = mat[0].length;
        DSU dsu = new DSU(n * m);
        for (int i = 0; i < m; ++i) {
            Map<Integer, List<Integer>> mp = new HashMap<>();
            for (int j = 0; j < n; ++j) {
                mp.computeIfAbsent(mat[i][j], key -> new ArrayList<>()).add(i * n + j);
            }
            for (var entry : mp.entrySet()) {
                for (int k = 1; k < entry.getValue().size(); ++k) {
                    dsu.union(entry.getValue().get(k - 1), entry.getValue().get(k));
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            Map<Integer, List<Integer>> mp = new HashMap<>();
            for (int j = 0; j < m; ++j) {
                mp.computeIfAbsent(mat[j][i], key -> new ArrayList<>()).add(j * n + i);
            }
            for (var entry : mp.entrySet()) {
                for (int k = 1; k < entry.getValue().size(); ++k) {
                    dsu.union(entry.getValue().get(k - 1), entry.getValue().get(k));
                }
            }
        }
        int[] indegree = new int[m * n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < m * n; ++i) adj.add(new ArrayList<>());

        for (int i = 0; i < m; ++i) {
            int[][] tmp = new int[n][2];
            for (int j = 0; j < n; ++j) {
                tmp[j][0] = mat[i][j];
                tmp[j][1] = j;
            }
            Arrays.sort(tmp, (a, b) -> a[0] - b[0]);
            for (int j = 1; j < n; ++j) {
                if (tmp[j - 1][0] != tmp[j][0]) {
                    int u = dsu.find(i * n + tmp[j - 1][1]);
                    int v = dsu.find(i * n + tmp[j][1]);
                    indegree[v]++;
                    adj.get(u).add(v);
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            int[][] tmp = new int[m][2];
            for (int j = 0; j < m; ++j) {
                tmp[j][0] = mat[j][i];
                tmp[j][1] = j;
            }
            Arrays.sort(tmp, (a, b) -> a[0] - b[0]);
            for (int j = 1; j < m; ++j) {
                if (tmp[j - 1][0] != tmp[j][0]) {
                    int u = dsu.find(tmp[j - 1][1] * n + i);
                    int v = dsu.find(tmp[j][1] * n + i);
                    indegree[v]++;
                    adj.get(u).add(v);
                }
            }
        }

        int[] ans = new int[n * m];
        Arrays.fill(ans, 1);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < m * n; ++i) {
            if (dsu.find(i) == i && indegree[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                ans[v] = Math.max(ans[v], ans[u] + 1);
                indegree[v]--;
                if (indegree[v] == 0) q.offer(v);
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res[i][j] = ans[dsu.find(i * n + j)];
            }
        }
        return res;
    }
    
    class DSU {
        int[] rank, p;
        public DSU(int n) {
            rank = new int[n];
            p = new int[n];
            for (int i = 0; i < n; ++i) {
                rank[i] = 1;
                p[i] = i;
            }
        }
        int find(int u) {
            if (p[u] != u) p[u] = find(p[u]);
            return p[u];
        }
        void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) return;
            if (rank[x] < rank[y]) p[x] = y;
            else p[y] = x;
            if (rank[x] == rank[y]) rank[x]++;
        }
    }
}
