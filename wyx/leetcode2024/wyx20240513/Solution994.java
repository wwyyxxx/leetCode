/*
 * @Author: Tungbo
 * @Date: 2024-05-13 15:52:34
 * @LastEditTime: 2024-05-13 16:12:25
 * @LastEditors: Tungbo
 * @Description: leecode: 994. 腐烂的橘子
 */
package wyx.leetcode2024.wyx20240513;

import java.util.LinkedList;
import java.util.Queue;

public class Solution994 {
    public int orangesRotting(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    count++;
                } else if (grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        int round = 0;

        while (count > 0 && !queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] temp = queue.poll();
                int row = temp[0];
                int col = temp[1];
                if (row - 1>=0 && grid[row - 1][col] == 1) {
                    count--;
                    grid[row - 1][col] = 0;
                    queue.add(new int[]{row - 1,col});
                }

                if (row + 1 < N && grid[row + 1][col] == 1) {
                    count--;
                    grid[row + 1][col] = 0;
                    queue.add(new int[]{row + 1,col});
                }

                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    count--;
                    grid[row][col - 1] = 0;
                    queue.add(new int[]{row,col - 1});
                }

                if (col + 1 < M && grid[row][col + 1] == 1) {
                    count--;
                    grid[row][col + 1] = 0;
                    queue.add(new int[]{row,col + 1});
                }
            }
            round++;
        }

        return count > 0 ? -1 : round;
    }
}
