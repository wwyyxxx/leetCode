/*
 * @Author: Tungbo
 * @Date: 2023-08-24 15:05:35
 * @LastEditTime: 2023-08-24 15:37:12
 * @LastEditors: Tungbo
 * @Description: leecode: 1267. 统计参与通信的服务器
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230821;

public class Solution1267 {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] vistedCol = new int[n];
        int[] vistedRow = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    vistedCol[i]++;
                    vistedRow[j]++;
                }
            }
        }
        int ans =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && (vistedCol[i] > 1 || vistedRow[j] > 1)) ans++;
            }
        }
        return ans;
    }
}
