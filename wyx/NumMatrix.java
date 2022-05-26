package wyx;

/*
 * @Author: Tungbo
 * @Date: 2022-04-21 11:02:51
 * @LastEditTime: 2022-04-21 11:35:10
 * @LastEditors: Tungbo
 * @Description: leecode: 二维子矩阵的和
 */
public class NumMatrix {
    
    int sum[][];

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m > 0) {
            int n = matrix[0].length;
            sum = new int[m][n+1];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    sum[i][j+1] = sum[i][j] + matrix[i][j];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for(int i = row1; i<=row2;i++) {
            res += sum[i][col2+1] - sum[i][col1];
        }
        return res;
    }

}