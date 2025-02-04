/*
 * @Author: Tungbo
 * @Date: 2022-09-04 16:49:44
 * @LastEditTime: 2022-09-04 16:58:58
 * @LastEditors: Tungbo
 * @Description: leecode: 1582. 二进制矩阵中的特殊位置
 * 
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220829;

public class Solution1582 {
    
    public int numSpecial(int[][] mat) {
        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1 && check(mat, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean check(int[][] mat, int i, int j) {
        for (int j2 = 0; j2 < mat[0].length; j2++) {
            if(j2 != j && mat[i][j2] == 1) {
                return false;
            }
        }
        for (int i2 = 0; i2 < mat.length; i2++) {
            if(i2 != i && mat[i2][j] == 1) {
                return false;
            }
        }
        return true;
    }

}
