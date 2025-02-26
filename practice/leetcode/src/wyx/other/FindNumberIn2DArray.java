package practice.leetcode.src.wyx.other;

/*
 * @Author: Tungbo
 * @Date: 2021-06-10 15:24:26
 * @LastEditTime: 2022-05-26 21:57:25
 * @LastEditors: Tungbo
 * @Description: leecode: 二维数组中的查找
 */
public class FindNumberIn2DArray {

    public static void main(String[] args) {

    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0 , col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] < target) {
                row++;
            } else if(matrix[row][col] > target) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }

}