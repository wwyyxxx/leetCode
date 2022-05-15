/*
 * @Author: Tungbo
 * @Date: 2022-05-15 10:47:28
 * @LastEditTime: 2022-05-13 11:11:35
 * @LastEditors: Tungbo
 * @Description: leecode: 48. 旋转图像
 * 
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 
 */
public class Solution048 {
    
    public void rotate(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix.length];
        int n = matrix.length-1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][n-i] = res[i][j];
            }
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                matrix[i][j] = res[i][j];
            }
        }
    }

}
