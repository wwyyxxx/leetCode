package practice.leetcode.src.wyx.leetcode2022.wyx20220530;

/*
 * @Author: Tungbo
 * @Date: 2022-05-31 17:20:24
 * @LastEditTime: 2022-05-31 17:43:58
 * @LastEditors: Tungbo
 * @Description: leecode: 221. 最大正方形
 * 
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * 
 */
public class Solution221 {

    public static void main(String[] args) {
        System.out.println(new Solution221().maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }

    
    int row, col;

    public int maximalSquare1(char[][] matrix) {
        int ans = 0;
        row = matrix.length;
        col = matrix[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == '1') {
                    //开始暴力遍历
                    int w = dfs(matrix, i, j);
                    ans = Math.max(ans, w*w);
                }
            }
        }
        return ans;
    }

    public int dfs(char[][] matrix, int r, int l) {
        //找到可以形成最大正方形的边--即短边
        int k = Math.min(row - r, col - l);
        boolean flag = true;
        //记录边长
        int maxSize = 1;
        for(int i = 1; i < k; i++) {
            //右下角
            if(matrix[r + i][l + i] == '0') break;

            //以斜边为界，上三角+下三角的判断
            for(int z = 0; z < i; z++) {
                if(matrix[r + i][l + z] == '0' || matrix[r + z][l + i] == '0') {
                    flag = false;
                    break;
                }
            }
            if(flag) maxSize = i+1; //满足条件+1
            else break;
        }
        return maxSize;
    }


    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        row = matrix.length;
        col = matrix[0].length;
        if(row == 0 || col == 0) return 0;
        //动归处理
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == '1') {
                    if(i == 0 || j == 0) {
                        //边界处理
                        dp[i][j] = 1;
                    } else {
                        //左、上、左上 三个方向找到最小的
                        dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]), dp[i-1][j-1]) + 1;
                    }
                    maxSide = Math.max(maxSide,dp[i][j]);
                }
            }
        }
        return maxSide*maxSide;
    }

}
