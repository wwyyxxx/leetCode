/*
 * @Author: Tungbo
 * @Date: 2022-12-19 15:37:02
 * @LastEditTime: 2022-12-19 16:45:20
 * @LastEditors: Tungbo
 * @Description: leecode: 1971. 寻找图中是否存在路径
 * 
 * 有一个具有 n 个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。
 * 图中的边用一个二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 
 * 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。
 * 
 * 请你确定是否存在从顶点 source 开始，到顶点 destination 结束的 有效路径 。
 * 给你数组 edges 和整数 n、source 和 destination，如果从 source 到 destination 存在 有效路径 ，则返回 true，否则返回 false 。
 * 
 */
package wyx.wyx20221219;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1971 {

    List<Integer>[] path;
    boolean[] vis;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        path = new List[n];
        vis = new boolean[n];
        Arrays.setAll(path, p -> new ArrayList<Integer>());
        for (int[] is : edges) {
            int a = is[0], b = is[1];
            path[a].add(b);
            path[b].add(a);
        }
        return dfs(source,destination);
    }

    private boolean dfs(int source, int destination) {
        if(source == destination) return true;
        vis[source] = true;
        for (Integer next : path[source]) {
            if(!vis[next] && dfs(next, destination)) return true;
        }
        return false;
    }

    //[[0,1],[1,2],[2,0]]
    // [[0,1],[0,2],[3,5],[5,4],[4,3]]
    private int[] p;
    public boolean validPath1(int n, int[][] edges, int source, int destination) {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (int[] is : edges) {
            p[find(is[0])] = find(is[1]);
        }
        return find(source) == find(destination);
    }

    private int find(int x) {
        if(p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

}
