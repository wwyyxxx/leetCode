/*
 * @Author: Tungbo
 * @Date: 2022-10-25 14:55:10
 * @LastEditTime: 2022-10-25 16:14:24
 * @LastEditors: Tungbo
 * @Description: leecode: 934. 最短的桥
 * 
 * 给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域
 * 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 
 * 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 
 * 返回必须翻转的 0 的最小数目
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution934 {

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        LinkedList<int[]> queue = new LinkedList<>();
        List<int[]> island = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                    grid[i][j] = -1;
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0], y = cell[1];
                        island.add(cell);
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dirs[k][0];
                            int ny = y + dirs[k][1];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 1) {
                                queue.offer(new int[] { nx, ny });
                                grid[nx][ny] = -1;
                            }
                        }
                    }
                    for (int[] js : island) {
                        queue.offer(js);
                    }
                    int step = 0;
                    while (!queue.isEmpty()) {
                        int sz = queue.size();
                        for (int k = 0; k < sz; k++) {
                            int[] cell = queue.poll();
                            int x = cell[0], y = cell[1];
                            for (int l = 0; l < 4; l++) {
                                int nx = x + dirs[l][0];
                                int ny = y + dirs[l][1];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                                    if (grid[nx][ny] == 0) {
                                        queue.offer(new int[] { nx, ny });
                                        grid[nx][ny] = -1;
                                    } else if (grid[nx][ny] == 1) {
                                        return step;
                                    }
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }
        return 0;
    }

}
