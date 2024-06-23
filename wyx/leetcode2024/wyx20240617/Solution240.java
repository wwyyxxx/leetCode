/*
 * @Author: Tungbo
 * @Date: 2024-06-23 16:38:16
 * @LastEditTime: 2024-06-23 16:38:20
 * @LastEditors: Tungbo
 * @Description: leecode: 240. 搜索二维矩阵 II
 */
package wyx.leetcode2024.wyx20240617;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i = n - 1, j = 0;
        while(i >= 0 && j < m) {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
}
