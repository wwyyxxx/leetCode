/*
 * @Author: Tungbo
 * @Date: 2023-02-05 16:54:01
 * @LastEditTime: 2023-02-05 17:05:15
 * @LastEditors: Tungbo
 * @Description: leecode: 1210. 穿过迷宫的最少移动次数
 */
package wyx.wyx20230130;

import java.util.ArrayList;

public class Solution1210 {
    private static int[][] DIRS = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };

    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        var vis = new boolean[n][n][2];
        var q = new ArrayList<int[]>();
        vis[0][0][0] = true;
        q.add(new int[] { 0, 0, 0 }); // 初始位置
        for (int step = 1; !q.isEmpty(); ++step) {
            var tmp = q;
            q = new ArrayList<>();
            for (var t : tmp) {
                for (var d : DIRS) {
                    int x = t[0] + d[0], y = t[1] + d[1], s = t[2] ^ d[2];
                    int x2 = x + s, y2 = y + (s ^ 1); // 蛇头
                    if (x2 < n && y2 < n && !vis[x][y][s] &&
                            grid[x][y] == 0 && grid[x2][y2] == 0 && (d[2] == 0 || grid[x + 1][y + 1] == 0)) {
                        if (x == n - 1 && y == n - 2)
                            return step; // 此时蛇头一定在 (n-1,n-1)
                        vis[x][y][s] = true;
                        q.add(new int[] { x, y, s });
                    }
                }
            }
        }
        return -1;
    }
}
