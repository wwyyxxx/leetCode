/*
 * @Author: Tungbo
 * @Date: 2024-06-22 17:23:54
 * @LastEditTime: 2024-06-22 17:41:42
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
package wyx.leetcode2024.wyx20240617;

public class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return;
        }
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = temp[i][j];

                matrix[j][n - i] = val;
            }
        }
        
    }
}
