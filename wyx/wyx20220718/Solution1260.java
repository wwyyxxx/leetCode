package wyx.wyx20220718;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author: Tungbo
 * @Date: 2022-07-20 18:41:37
 * @LastEditTime: 2022-07-20 19:12:08
 * @LastEditors: Tungbo
 * @Description: leecode: 1260. 二维网格迁移
 * 
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * 每次「迁移」操作将会引发下述活动：
 *  位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 *  位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 *  位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格
 * 
 */
public class Solution1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[][] ans = new int[grid.length][grid[0].length];
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 需要下移的行数 ：(j + k) / n
                // i + 需要下移的行数 = 转换到的行
                // 目标行 = 转换到的行 % m
                int row = ( i + ((j + k) / n) ) % m;
                int col = (j + k) % n;
                ans[row][col] = grid[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                temp.add(ans[i][j]);
            }
            result.add(temp);
        }
        return result;
    }
}
