/*
 * @Author: Tungbo
 * @Date: 2022-09-30 10:16:50
 * @LastEditTime: 2022-09-30 10:25:16
 * @LastEditors: Tungbo
 * @Description: leecode: 面试题 01.08. 零矩阵
 * 
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * 
 */

package practice.leetcode.src.wyx.leetcode2022.wyx20220926;

import java.util.ArrayList;
import java.util.List;

public class Solution01_08 {

    public void setZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList<int[]>();
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        for (int[] is : list) {
            for (int i = 0; i < m; i++) {
                matrix[is[0]][i] = 0;
            }
            for (int i = 0; i < n; i++) {
                matrix[i][is[1]] = 0;
            }
        }
    }

}
