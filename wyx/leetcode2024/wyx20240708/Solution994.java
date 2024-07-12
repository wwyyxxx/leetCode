/*
 * @Author: Tungbo
 * @Date: 2024-07-12 17:48:26
 * @LastEditTime: 2024-07-12 18:56:19
 * @LastEditors: Tungbo
 * @Description: leecode: 994. 腐烂的橘子
 */
package wyx.leetcode2024.wyx20240708;

import java.util.LinkedList;
import java.util.Queue;

public class Solution994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int newCnt = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    newCnt++;
                } else if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
            }
        }

        int round = 0;
        
        while (newCnt > 0 && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                int x = temp[0], y = temp[1];
                if (x - 1 >= 0 && grid[x-1][y] == 1) {
                    newCnt--;
                    grid[x-1][y] = 0;
                    q.add(new int[]{x-1,y});
                }
                if (x + 1 < m && grid[x+1][y] == 1) {
                    newCnt--;
                    grid[x+1][y]=0;
                    q.add(new int[]{x+1,y});
                }

                if (y - 1 >= 0 && grid[x][y-1] == 1) {
                    newCnt--;
                    grid[x][y-1] = 0;
                    q.add(new int[]{x,y-1});
                }
                if (y + 1 < n && grid[x][y+1] == 1) {
                    newCnt--;
                    grid[x][y+1] = 0;
                    q.add(new int[]{x,y+1});
                }
            }
            round++;
        }

        return newCnt > 0 ? -1 : round;
    }
}
