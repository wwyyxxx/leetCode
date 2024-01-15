/*
 * @Author: Tungbo
 * @Date: 2023-04-15 12:38:00
 * @LastEditTime: 2023-04-15 12:38:04
 * @LastEditors: Tungbo
 * @Description: leecode: 1042. 不邻接植花
 */
package wyx.wyx20230410;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1042 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer> g[] = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : paths) {
            int x = e[0] - 1, y = e[1] - 1; // 编号改从 0 开始
            g[x].add(y);
            g[y].add(x); // 建图
        }
        int[] color = new int[n];
        for (int i = 0; i < n; ++i) {
            boolean[] used = new boolean[5];
            for (int j : g[i])
                used[color[j]] = true;
            while (used[++color[i]]);
        }
        return color;
    }
}
