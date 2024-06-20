/*
 * @Author: Tungbo
 * @Date: 2024-06-20 19:15:41
 * @LastEditTime: 2024-06-20 19:20:58
 * @LastEditors: Tungbo
 * @Description: leecode: 73. 矩阵置零
 */
package wyx.leetcode2024.wyx20240617;

import java.util.HashSet;
import java.util.Set;

public class Solution73 {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowDic = new HashSet<>();
        Set<Integer> colDic = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    colDic.add(i);
                    rowDic.add(j);
                }
            }
        }
        for(int col : colDic){
            for(int i = 0; i < n; i++) {
                matrix[col][i] = 0;
            }
        }
        for(int row : rowDic){
            for(int i = 0; i < m; i++) {
                matrix[i][row] = 0;
            }
        }
    }
}
