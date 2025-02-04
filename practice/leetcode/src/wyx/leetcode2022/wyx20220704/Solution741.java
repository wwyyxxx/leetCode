/*
 * @Author: Tungbo
 * @Date: 2022-07-10 16:14:57
 * @LastEditTime: 2022-07-10 17:27:09
 * @LastEditors: Tungbo
 * @Description: leecode: 741. 摘樱桃
 * 
 * 一个N x N的网格(grid) 代表了一块樱桃地，每个格子由以下三种数字的一种来表示：
 *  0 表示这个格子是空的，所以你可以穿过它。
 *  1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。
 *  -1 表示这个格子里有荆棘，挡着你的路。
 * 
 * 你的任务是在遵守下列规则的情况下，尽可能的摘到最多樱桃：
 *  从位置 (0, 0) 出发，最后到达 (N-1, N-1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为0或者1的格子）；
 *  当到达 (N-1, N-1) 后，你要继续走，直到返回到 (0, 0) ，只能向上或向左走，并且只能穿越有效的格子；
 *  当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为0）；
 *  如果在 (0, 0) 和 (N-1, N-1) 之间不存在一条可经过的路径，则没有任何一个樱桃能被摘到。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220704;

import java.util.Arrays;

public class Solution741 {
 
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}};

    private int[][] grid;

    private int n;

    private Integer[][][][] memo;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.memo = new Integer[n][n][n][n];
        return Math.max(0, helper(0, 0, 0, 0));
    }

    private int helper(int x1, int y1, int x2, int y2) {
        if (x1 == n - 1 && y1 == x1) {
            return grid[n - 1][n - 1];
        }
        if (memo[x1][y1][x2][y2] != null) {
            return memo[x1][y1][x2][y2];
        }
        int res = Integer.MIN_VALUE, cur = 0;
        if (x1 == x2 && y1 == y2) {
            cur = grid[x1][y1];
        } else {
            cur = grid[x1][y1] + grid[x2][y2];
        }
        for (int[] direction1 : DIRECTIONS) {
            int nextX1 = direction1[0] + x1;
            int nextY1 = direction1[1] + y1;
            if (nextX1 >= 0 && nextX1 < n && nextY1 >= 0 && nextY1 < n && grid[nextX1][nextY1] != -1) {
                for (int[] direction2 : DIRECTIONS) {
                    int nextX2 = direction2[0] + x2;
                    int nextY2 = direction2[1] + y2;
                    if (nextX2 >= 0 && nextX2 < n && nextY2 >= 0 && nextY2 < n && grid[nextX2][nextY2] != -1) {
                        res = Math.max(res, cur + helper(nextX1, nextY1, nextX2, nextY2));
                    }
                }
            }
        }
        memo[x1][y1][x2][y2] = res;
        return res;
    }

}
