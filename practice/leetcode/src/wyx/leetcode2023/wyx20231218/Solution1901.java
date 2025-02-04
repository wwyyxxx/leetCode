/*
 * @Author: Tungbo
 * @Date: 2023-12-19 15:46:29
 * @LastEditTime: 2023-12-19 15:52:56
 * @LastEditors: Tungbo
 * @Description: leecode: 1901. 寻找峰值 II
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20231218;

public class Solution1901 {
    public int[] findPeakGrid(int[][] mat) {
        int left = 0, right = mat.length - 2;
        while (left <= right) {
            int i = left + (right - left) /2;
            int j = indexOfMax(mat[i]);
            if(mat[i][j] > mat[i+1][j]) {
                right = i -1;
            } else {
                left = i +1;
            }
         }
         return new int[]{left, indexOfMax(mat[left])};
    }

    private int indexOfMax(int[] a) {
        int idx = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] > a[idx]) {
                idx = i;
            }
        }
        return idx;
    }
}
