/*
 * @Author: Tungbo
 * @Date: 2024-06-21 19:24:07
 * @LastEditTime: 2024-06-21 20:03:46
 * @LastEditors: Tungbo
 * @Description: leecode: 54. 螺旋矩阵
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240617;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        Integer[] res = new Integer[(r + 1) * (b + 1)];
        while (true) {
            // left -> rigth
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i];
            
            if (++t > b) { break; }
            // top -> bottom
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r];
            
            if (--r < l) { break; }
            // left -> right
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i];
            
            if (--b < t) { break; }
            // bottom -> top
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l];
            
            if (++l > r) { break; }
        }
        return Arrays.asList(res);
    }
}
