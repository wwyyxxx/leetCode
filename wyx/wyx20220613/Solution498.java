/*
 * @Author: Tungbo
 * @Date: 2022-06-14 11:44:24
 * @LastEditTime: 2022-06-14 15:11:55
 * @LastEditors: Tungbo
 * @Description: leecode: 498. 对角线遍历
 * 
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * 
 */
package wyx.wyx20220613;

public class Solution498 {
    
    public static void main(String[] args) {
        System.out.println(new Solution498().findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int[][] dic = new int[][]{{-1,1},{1,-1}};
        Boolean btt = true;
        int n = mat.length;
        int m = mat[0].length;
        int[] ans = new int[n*m];
        int i = 0, j = 0, idx = 0;
        while(i < n && j < m) {
            ans[idx++] = mat[i][j];
            int nx = i, ny = j;
            if(btt) {
                nx += dic[0][0];
                ny += dic[0][1];
            } else {
                nx += dic[1][0];
                ny += dic[1][1];
            }

            if(idx < m * n && (nx < 0 || nx >= n || ny < 0 || ny >= m)) {
                if(btt) {
                    nx = j + 1 < m ? i : i + 1;
                    ny = j + 1 < m ? j + 1 : j;
                } else {
                    nx = i + 1 < n ? i + 1 : i;
                    ny = i + 1 < n ? j : j + 1;
                }
                btt = !btt;
            }
            i = nx; 
            j = ny;
            // if(i < 0){
            //     i = j >= m ? i + 2 : 0;
            //     j = j >= m ? j - 1 : j;
            //     btt = !btt;
            // }
            // if(j < 0) {
            //     j = 0;
            //     btt = !btt;
            // }
            // i >= n     j >= m
            
            // if(i >= n) {
            //     i = n-1;
            //     j += 2;
            // }
            // if(j >= m ) {
            //     j = m-1;
            //     i += 2;
            // }
        }
        return ans;
    }
}
