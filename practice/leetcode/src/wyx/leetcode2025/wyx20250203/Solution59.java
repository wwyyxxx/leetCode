package practice.leetcode.src.wyx.leetcode2025.wyx20250203;
/*
 * @Author: Tungbo
 * @Date: 2025-02-07 00:23:31
 * @LastEditTime: 2025-02-07 00:57:24
 * @LastEditors: Tungbo
 * @Description: leecode: 59. 螺旋矩阵 II
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int l = 0, r = n -1, t = 0, b = n -1; 
        int num = 1, target = n * n;
        while (num <= target) {
            for (int i = l; i <= r; i++) {
                result[t][i] = num++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                result[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                result[b][i] = num++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                result[i][l] = num++;
            }
            l++;
        }
        return result;
    }
}
