/*
 * @Author: Tungbo
 * @Date: 2023-01-31 19:41:41
 * @LastEditTime: 2023-01-31 20:01:25
 * @LastEditors: Tungbo
 * @Description: leecode: 2319. 判断矩阵是否是一个 X 矩阵
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230130;

public class Solution2319 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0;j<m;j++) {
                int num = grid[i][j];
                if(i==j || i+j == n-1) {
                    if(num == 0) return false;
                } else if(num != 0) return false;
            }
        }
        return true;
    }
}
