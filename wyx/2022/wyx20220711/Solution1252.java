/*
 * @Author: Tungbo
 * @Date: 2022-07-12 15:19:29
 * @LastEditTime: 2022-07-12 15:28:21
 * @LastEditors: Tungbo
 * @Description: leecode: 1252. 奇数值单元格的数目
 * 
 * 给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
 * 另有一个二维索引数组 indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 * 对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
 *  ri 行上的所有单元格，加 1 。
 *  ci 列上的所有单元格，加 1 。
 * 给你 m、n 和 indices 。请你在执行完所有 indices 指定的增量操作后，返回矩阵中 奇数值单元格 的数目。
 * 
 */
package wyx.wyx20220711;

public class Solution1252 {
    
    public int oddCells(int m, int n, int[][] indices) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < indices.length; i++) {
            int[] cell = indices[i];
            for (int j = 0; j < grid.length; j++) {
                grid[j][cell[1]] += 1;
            }
            for (int j = 0; j < grid[0].length; j++) {
                grid[cell[0]][j] += 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] % 2 == 1) ans++;
            }
        }
        return ans;
    }

}
