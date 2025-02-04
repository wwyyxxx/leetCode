package practice.leetcode.src.wyx.leetcode2023.wyx20230227;

/*
 * @Author: Tungbo
 * @Date: 2023-03-01 11:39:52
 * @LastEditTime: 2023-03-01 11:39:56
 * @LastEditors: Tungbo
 * @Description: leecode: 2373. 矩阵中的局部最大值
 */
public class Solution2373 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n-2][n-2];
        for(int i = 0; i < n - 2; i++) {
            for(int j = 0; j < n - 2; j++) {
                for(int x = i; x <= i+2; x++) {
                    for(int y = j; y <= j+2; y++) {
                        ans[i][j] = Math.max(ans[i][j],grid[x][y]);
                    }
                }
            }
        }
        return ans;
    }
}
