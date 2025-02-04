/*
 * @Author: Tungbo
 * @Date: 2024-04-12 17:12:08
 * @LastEditTime: 2024-04-12 17:12:10
 * @LastEditors: Tungbo
 * @Description: leecode: 2923. 找到冠军 I
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240408;

class Solution2923 {
    public int findChampion(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        next:
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         if(i != j && grid[i][j] == 0) {
        //             continue next;
        //         }
        //     }
        //     return i;
        // }
        for(int j = 0; j < n; j++) {
            for(int[] row : grid) {
                if(row[j] != 0) { continue next;}
            }
            return j;
        }

        return -1;
    }
    
}